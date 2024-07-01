import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int cur = 0, answer = 0;
        int job[];
        PriorityQueue<int[]> durQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        PriorityQueue<int[]> timeQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        
        for (int[] j : jobs)
            timeQueue.add(j);
        
        while (true) {
            if (timeQueue.size() < 1 && durQueue.size() < 1)
                break;
            
            while (timeQueue.size() > 0 && timeQueue.peek()[0] <= cur ) {
                durQueue.add(timeQueue.poll());
            }
            
            if (durQueue.size() < 1) {
                cur++;
                continue;
            } else {
                job = durQueue.poll();
            }
            
            if (job[0] <= cur) {
                answer += (cur - job[0]) + job[1];
                cur += job[1];
            } else {
                cur++;
                continue;
            }
        }
        
        return answer / jobs.length;
    }
}