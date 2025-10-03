import java.util.*;
import java.util.stream.*;

// 소요시간 - 요청 시각 - 번호 작음
// job: [요청시점, 소요시간]
// enqueue: [요청시점, 소요시간, 번호]
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, time = 0, idx = 0, end_time = 0, times = 0;
        int[] cur_work = null;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[0] == o2[0]) {
                        return o1[2] - o2[2];
                    } else
                        return o1[0] - o2[0];
                } else
                    return o1[1] - o2[1];
            }
        });
        
        Arrays.sort(jobs, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        
        while (true) {
            if (idx >= jobs.length && pq.isEmpty() && time >= end_time)
                break;
            
            // 요청 들어오면 큐에 넣음
            if (idx < jobs.length && time == jobs[idx][0]) {
                while (idx < jobs.length && jobs[idx][0] == time) {
                    pq.add(new int[] {jobs[idx][0], jobs[idx][1], idx});
                    idx++;
                }
            }
            
            // 처음이거나 작업 완료되면 새로운 작업 시작
            if ((cur_work == null || end_time <= time) && !pq.isEmpty()) {
                cur_work = pq.poll();
                end_time = time + cur_work[1];
                times += (end_time - cur_work[0]);
                
                if (pq.isEmpty() && idx >= jobs.length)
                    break;
            }
            
            time++;
        }
        
        answer = times / jobs.length;
        
        return answer;
    }
}