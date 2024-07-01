import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        String number = "";
        String[] arr = numbers.split("");
        boolean[] using = new boolean[arr.length];
        HashSet<Integer> result = new HashSet<>();
        Arrays.fill(using, false);
        
        findSomething(result, arr, using, number);
        answer = result.size();
        
        return answer;
    }
    
    void findSomething(HashSet<Integer> result, String[] arr, boolean[] using, String num) {
        System.out.print(num + " ");
        if (num.length() > 0)
            if (primeCheck(Integer.parseInt(num)))
                result.add(Integer.parseInt(num));
        
        for (int i=0; i<arr.length; i++) {
            if (num.length() < arr.length) {
                if (using[i])
                    continue;
                else
                    using[i] = true;
                findSomething(result, arr, using, num.concat(arr[i]));
            }
            else {
                if (using[i])
                    continue;
                else
                    using[i] = true;
                if (primeCheck(Integer.parseInt(num.concat(arr[i])))) {
                    result.add(Integer.parseInt(num.concat(arr[i])));
                }
            }
            
            using[i] = false;
        }
    }
    
    boolean primeCheck(int num) {
        if (num == 2)
            return true;
        
        if (num % 2 == 0 || num < 2)
            return false;
        
        for (int i=3; i<num; i+=2) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
}