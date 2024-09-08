import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int temp = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int work : works)
            pq.add(work);
        
        temp = pq.poll();
        
        while (n > 0) {            
            if (temp >= pq.peek()) {
                temp--;
                n--;
            } else {
                pq.add(temp);
                temp = pq.poll();
            }
        }
        
        pq.add(temp);
        
        // for (Integer work : pq) {
        //     if (work <= 0)
        //         continue;
        //     answer += ((long) work * (long) work);
        // }
        
        return pq.stream()
            .filter(a -> a > 0)
            .mapToLong(a -> (long) a * (long) a)
            .sum();
    }
}