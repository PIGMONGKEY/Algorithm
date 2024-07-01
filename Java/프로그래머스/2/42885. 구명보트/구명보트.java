import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, curWeight = 0, i = 0, front = 0, end = people.length - 1;
        int[] flag = new int[people.length];
        
        Arrays.sort(people);
        
        while (true) {
            if (flag[end] > 0)
                break;
            else if (end == front) {
                answer++;
                break;
            }
            
            if (people[end] + people[front] <= limit) {
                answer++;
                flag[end]++;
                flag[front]++;
                end--;
                front++;
            } else {
                answer++;
                flag[end]++;
                end--;
            }
        }
        
        return answer;
    }
}