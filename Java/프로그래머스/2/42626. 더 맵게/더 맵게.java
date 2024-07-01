import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int min, smin, answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int s : scoville)
            queue.add(s);
        
        while (queue.peek() < K) {
            if (answer >= scoville.length || queue.size() < 2) {
                answer = -1;
                break;
            }
            
            min = queue.poll();
            smin = queue.poll();
            
            queue.add(min + (2 * smin));
            
            answer++;
        }
        
        return answer;
    }
}