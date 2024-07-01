import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] parents = new int[n];
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0; i<n; i++)
            parents[i] = i;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j)
                    continue;
                if (computers[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        
        for (int i=0; i<n; i++)
            set.add(getParent(parents, i));
        
        answer = set.size();
        
        return answer;
    }
    
    int getParent(int[] parents, int a) {
        if (parents[a] == a)
            return a;
        else
            return parents[a] = getParent(parents, parents[a]);
    }
    
    void union(int[] parents, int a, int b) {
        a = getParent(parents, a);
        b = getParent(parents, b);
        
        if (a > b)
            parents[a] = b;
        else if (b > a)
            parents[b] = a;
    }
}