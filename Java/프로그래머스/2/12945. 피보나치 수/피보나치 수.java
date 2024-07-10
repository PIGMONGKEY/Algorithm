import java.math.*;

class Solution {
    public int solution(int n) {
        long[] memo = new long[n+1];
        
        memo[0] = 0L;
        memo[1] = 1L;
        
        for (int i=2; i<=n; i++)
            memo[i] = (memo[i-2] + memo[i-1]) % 1234567L;
        
        return (int) memo[n];
    }
}