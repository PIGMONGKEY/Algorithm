import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0, num;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        
        for (int t : topping)
            right.put(t, right.get(t) == null ? 1 : right.get(t) + 1);
        
        for (int i=0; i<topping.length; i++) {
            num = topping[i];
            left.put(num, left.get(num) == null ? 1 : left.get(num) + 1);
            if (right.get(num) > 1)
                right.put(num, right.get(num) - 1);
            else
                right.remove(num);
            
            if (left.size() == right.size())
                answer++;
        }
        
        return answer;
    }
}