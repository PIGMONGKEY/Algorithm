import java.util.*;

class Solution {
    
    private static ArrayList<int[]>[] map;
    private static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        
        // 인접리스트로 변경
        for (int i=0; i<=N; i++)
            map[i] = new ArrayList<int[]>();
        
        for (int[] r : road) {
            map[r[0]].add(new int[] {r[1], r[2]});
            map[r[1]].add(new int[] {r[0], r[2]});
        }
        
        for (int i=2; i<=N; i++) {
            if (getDistance(i) <= K)
                answer++;
        }

        return answer;
    }
    
    // 너비 우선 탐색, 그런데 이제 가중치 우선순위 큐를 곁들인...
    private int getDistance(int dest) {
        int cur, dist = 0;
        int[] temp;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> { return o1[1] - o2[1]; });
        
        queue.add(new int[] {1, dist});
        
        while (!queue.isEmpty()) {
            temp = queue.poll();
            cur = temp[0];
            dist = temp[1];
            
            if (cur == dest)
                break;
            
            if (visited[cur])
                continue;
            
            visited[cur] = true;
            
            for (int[] n : map[cur])
                queue.add(new int[] {n[0], n[1] + dist});
        }
        
        Arrays.fill(visited, false);
        
        return dist;
    }
}