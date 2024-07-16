import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int next, max = Integer.MIN_VALUE;
        
        int[] answer = new int[numbers.length];
        int[] memo = new int[numbers.length];
        
        // 각 자리 이후 숫자 중 최댓값을 찾아 각 자리에 메모
        for (int i=numbers.length-1; i>=0; i--) {
            max = max > numbers[i] ? max : numbers[i];
            memo[i] = max;
        }
        
        // 각 자리가 메모한 수와 같으면 자신이 최댓값이니 -1 저장
        // 다음 숫자와 지금 숫자가 같으면 같은 답을 저장
        // 다음 숫자보다 지금 숫자가 작으면 다음 숫자를 지금 숫자의 답으로 저장
        // 다음 숫자보다 지금 숫자가 크면 
        for (int i=numbers.length-1; i>=0; i--) {            
            next = i + 1;
            
            if (numbers[i] == memo[i]) {
                answer[i] = -1;
                continue;
            }
            
            if (numbers[i] == numbers[next]) {
                answer[i] = answer[next];
            } else if (numbers[i] < numbers[next]) {
                answer[i] = numbers[next];
            } else {
                while (true) {
                    if (numbers[i] == numbers[next]) {
                        answer[i] = answer[next];
                        break;
                    } else if (numbers[i] < numbers[next]) {
                        answer[i] = numbers[next];
                        break;
                    }
                    next++;
                }
            }
        }
        
        return answer;
    }
}