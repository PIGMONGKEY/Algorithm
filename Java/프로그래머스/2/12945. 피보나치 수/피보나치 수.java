import java.math.*;

class Solution {
    public int solution(int n) {
        return fibonacci(new BigInteger("0"), new BigInteger("1"), 1, n).remainder(new BigInteger("1234567")).intValue();
    }
    
    BigInteger fibonacci(BigInteger a, BigInteger b, int cur, int n) {
        if (cur == n)
            return b;
        
        return fibonacci(b, a.add(b), cur + 1, n);
    }
}