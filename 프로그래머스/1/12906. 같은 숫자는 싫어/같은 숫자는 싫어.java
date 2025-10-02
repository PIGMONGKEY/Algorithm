import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        for (int item : arr) {
            if (!stack.isEmpty() && stack.peek() == item)
                continue;
            
            stack.push(item);
        }
        
        answer = new int[stack.size()];
        
        for (int i=stack.size() - 1; i>=0; i--)
            answer[i] = stack.pop();
        
        return answer;
    }
}