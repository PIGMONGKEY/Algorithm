import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0, index;
        StringBuilder sb;
        String curNum;
        
        // 진법 변환
        sb = changeBase(n, k);
        
        // 0으로 시작하면 해당 0 제거
        // 다음 0 이전까지 끊어서 만든 숫자 소수 체크
        // 이후 해당 숫자는 문자열에서 제거
        while (sb.length() > 0) {
            index = sb.indexOf("0");
            
            if (index == 0) {
                sb.delete(0, 1);
                continue;
            } else if (index == -1)
                index = sb.length();
            
            curNum = sb.substring(0, index);
            sb.delete(0, index);
            
            if (checkPrime(curNum))
                answer++;
        }
        
        return answer;
    }
    
    // k 진법으로 변환
    StringBuilder changeBase(int n, int k) {
        int remain;
        StringBuilder sb = new StringBuilder();
        
        if (k == 10)
            return new StringBuilder(Integer.valueOf(n).toString());
        
        do {
            remain = n % k;
            n /= k;
            sb.append(remain);
        } while (n > 0);
        
        return sb.reverse();
    }
    
    // 소수 체크
    boolean checkPrime(String num) {
        long n = Long.parseLong(num);
        long s = (long) Math.sqrt((double) n);

        if (n == 2)
            return true;

        if (n % 2 == 0 || n < 2)
            return false;

        for (long i=3; i<=s; i = i + 2)
            if (n % i == 0)
                return false;

        return true;
    }
}