import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int max = 0;
        int[] cur;
        int[] dist = new int[n];
        int[] visited = new int[n+1];
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        LinkedList<int[]> queue = new LinkedList<>();
        
        for (int[] e : edge) {
            if (!hash.containsKey(e[0]))
                hash.put(e[0], new ArrayList<>());
            if (!hash.containsKey(e[1]))
                hash.put(e[1], new ArrayList<>());
            
            hash.get(e[0]).add(e[1]);
            hash.get(e[1]).add(e[0]);
        }
        
        queue.push(new int[] { 1, 0 });

        while (!queue.isEmpty()) {
            cur = queue.pollLast();
            
            if (visited[cur[0]] == 1)
                continue;
            
            dist[cur[1]]++;
            visited[cur[0]] = 1;
            max = Math.max(max, cur[1]);
            
            if (!hash.containsKey(cur[0]))
                continue;
            
            for (int next : hash.get(cur[0]))                
                queue.push(new int[] { next, cur[1] + 1 });
        }
        
        return dist[max];
    }
}