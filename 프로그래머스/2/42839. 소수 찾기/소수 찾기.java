import java.util.*;

class Solution {
    int[] visited;
    ArrayList<Integer> list;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new int[numbers.length()];
        list = new ArrayList<>();
        
        answer = findNumberCount(numbers, "");
        
        return answer;
    }
    
    private int findNumberCount(String numbers, String curNum) {
        int count = 0;
        
        System.out.println(curNum);
        
        if (curNum.length() > 0 && isPrime(Integer.parseInt(curNum)) && !list.contains(Integer.parseInt(curNum))) {
            count++;
            list.add(Integer.parseInt(curNum));
        }

        for (int i=0; i<numbers.length(); i++) {
            if (visited[i] == 1)
                continue;
            
            visited[i] = 1;
            count += findNumberCount(numbers, curNum.concat(numbers.substring(i, i+1)));
            visited[i] = 0;
        }
        
        return count;
    }
    
    private boolean isPrime(int num) {
        if (num == 2)
            return true;
        
        if (num < 2)
            return false;
        
        for (int i=2; i<(int) Math.sqrt((double) num)+1; i++)
            if (num % i == 0)
                return false;
        
        return true;
    }
}