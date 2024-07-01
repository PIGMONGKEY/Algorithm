import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int process, answer = 1, defaultValue = priorities[location];
        LinkedList<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int p : priorities) {
            queue.add(p);
            pQueue.add(p);
        }
        
        queue.set(location, 10);
        
        while(true) {
            process = queue.poll();
            
            if (process == 10) {
                if (defaultValue == pQueue.peek())
                    break;
            }
            
            if (process == pQueue.peek()) {
                pQueue.poll();
                answer++;
            } else {
                queue.add(process);
            }
        }
        
        return answer;
    }
}