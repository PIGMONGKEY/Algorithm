import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int round = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int e : enemy) {
            pq.add(e);
            
            if (n >= e) {
                n -= e;
                round++;
            } else if (k > 0) {
                n += pq.poll();
                n -= e;
                round++;
                k--;
            } else
                break;
        }
        
        return round - 1;
    }
}