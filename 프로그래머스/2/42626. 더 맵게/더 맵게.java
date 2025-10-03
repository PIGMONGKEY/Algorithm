import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int last, next, answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while (pq.peek() < K) {
            if (pq.size() < 2)
                return -1;
            
            last = pq.poll();
            next = pq.poll();
            
            pq.add(last + (next * 2));
            
            answer++;
        }
        
        return answer;
    }
}