import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        String[] ops;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> r_pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (String op : operations) {
            ops = op.split(" ");
            
            if (ops[0].equals("I")) {
                pq.add(new Integer(ops[1]));
                r_pq.add(new Integer(ops[1]));
                continue;
            }
            
            if (pq.isEmpty())
                continue;
            
            if (ops[1].equals("1")) {
                pq.remove(r_pq.poll());
            } else {
                r_pq.remove(pq.poll());
            }
        }

        return pq.isEmpty() ? new int[] { 0, 0 } : new int[] { r_pq.poll(), pq.poll() };
    }
}