import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        PriorityQueue<Integer> resultQueue = new PriorityQueue<>(Collections.reverseOrder());
        int[] flag = new int[dungeons.length];
        
        search(resultQueue, dungeons, flag, k, 0);
        
        answer = resultQueue.poll();
        
        return answer;
    }
    
    void search(PriorityQueue<Integer> resultQueue, int[][] dungeons, int[] flag, int k, int count) {
        boolean isDone = false;
        if (!resultQueue.isEmpty() && resultQueue.peek() == dungeons.length)
            return;
        
        for (int i=0; i<dungeons.length; i++) {
            if (k >= dungeons[i][0] && flag[i] < 1) {
                isDone = true;
                flag[i]++;
                try {
                    search(resultQueue, dungeons, flag, k - dungeons[i][1], count + 1);
                } catch (NullPointerException e) {
                    System.out.println(dungeons.length + " " + i);
                    return;
                }
                flag[i]--;
            }
        }
        
        if (!isDone) {
            resultQueue.add(count);
            return;
        }
    }
}