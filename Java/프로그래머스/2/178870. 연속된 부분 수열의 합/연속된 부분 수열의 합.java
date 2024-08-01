import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int front = 0, end = 0, sum = sequence[0], length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (end < sequence.length) {
            if (sum < k && front + 1 < sequence.length) {
                    front++;
                    sum += sequence[front];
            } else {
                if (sum == k && (front - end) + 1 < length) {
                    answer[0] = end;
                    answer[1] = front;
                    length = (front - end) + 1;
                }
                
                sum -= sequence[end];
                end++;
            }
        }
        
        return answer;
    }
}