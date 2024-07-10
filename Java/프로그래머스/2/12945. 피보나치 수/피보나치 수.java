import java.math.*;

class Solution {
    public int solution(int n) {
        BigInteger[] memo = new BigInteger[n+1];
        
        memo[0] = new BigInteger("0");
        memo[1] = new BigInteger("1");
        
        for (int i=2; i<=n; i++) {
            memo[i] = memo[i-2].add(memo[i-1]);
        }
        
        return memo[n].remainder(new BigInteger("1234567")).intValue();
    }
}