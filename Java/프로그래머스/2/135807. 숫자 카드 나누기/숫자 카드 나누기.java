import java.util.*;

class Solution {
    
    private static PriorityQueue<Integer> divisors;
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0, divisor = 0;
        divisors = new PriorityQueue<>(Collections.reverseOrder());
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        return Math.max(findAnswer(arrayA, arrayB), findAnswer(arrayB, arrayA));
    }
    
    private void findDivisors(int num) {
        for (int i=1; i*i<=num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }
    }
    
    private boolean checkCommonDivisor(int num, int[] arr) {
        for (int n : arr)
            if (n % num != 0)
                return false;
        
        return true;
    }
    
    private boolean checkDivisorValid(int num, int[] arr) {
        for (int n : arr)
            if (n % num == 0)
                return false;
        
        return true;
    }
    
    private int findAnswer(int[] arr1, int[] arr2) {
        int divisor, answer = 0;
        findDivisors(arr1[0]);
        
        while (!divisors.isEmpty()) {
            divisor = divisors.poll();
            
            if (divisor == 1)
                break;
            
            if (checkCommonDivisor(divisor, arr1)) {
                if (checkDivisorValid(divisor, arr2)) {
                    answer = divisor;
                    break;
                }
            }
        }
        
        divisors.clear();
        return answer;
    }
}