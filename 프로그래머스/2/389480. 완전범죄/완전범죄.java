class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int aInfo, bInfo;
        boolean[][] dp = new boolean[n][m];
        boolean[][] next;
        
        dp[0][0] = true;
        
        for (int[] item : info) {
            aInfo = item[0];
            bInfo = item[1];
            next = new boolean[n][m];
            
            for (int aSum=0; aSum<n; aSum++) {
                for (int bSum=0; bSum<m; bSum++) {
                    if (!dp[aSum][bSum])
                        continue;
                    
                    if (aSum + aInfo < n)
                        next[aSum + aInfo][bSum] = true;

                    if (bSum + bInfo < m)
                        next[aSum][bSum + bInfo] = true;
                }
            }
            
            dp = next;
        }
        
        for (int a=0; a<n; a++)
            for (int b=0; b<m; b++)
                if (dp[a][b])
                    return a;
        
        return -1;
    }
}