import java.math.*;

class Solution {
    public int solution(int n) {
        return fibonacci(0, 1, 1, n);
    }
    
    int fibonacci(int a, int b, int cur, int n) {
        if (cur == n)
            return b;
        
        return fibonacci(b, (a + b) % 1234567, cur + 1, n);
    }
}