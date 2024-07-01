import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0, a, b, val, count = 0;
        int[] parents = new int[n];
        
        for (int i=0; i<n; i++)
            parents[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> { return o1[2] - o2[2]; });
        
        for (int[] cost : costs) {
            a = cost[0];
            b= cost[1];
            val = cost[2];
            
            if (union(parents, a, b)) {
                answer += val;
                count++;
            }
        }
        
        return answer;
    }
    
    int find(int[] parents, int a) {
        if (parents[a] == a)
            return a;
        else
            return find(parents, parents[a]);
    }
    
    boolean union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);
        if (a != b) {
            parents[b] = a;
            return true;
        } else
            return false;
    }
}