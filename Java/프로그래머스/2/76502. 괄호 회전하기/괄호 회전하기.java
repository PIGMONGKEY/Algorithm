import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        
        int length = s.length();
        int answer = 0;
        
        for (int i=0; i<length; i++) {
            if (checkValidString(stack, length, sb))
                answer++;
            
            sb.append(sb.charAt(0));
            sb = sb.deleteCharAt(0);
        }
        
        return answer;
    }
    
    boolean checkValidString(Stack<Character> stack, int length, StringBuilder sb) {
        char c;
        for (int i=0; i<length; i++) {
            c = sb.charAt(i);
            
            if (c == '{' || c == '[' || c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (stack.peek() == c - 1 || stack.peek() == c - 2)
                    stack.pop();
            }
        }
        
        if (stack.isEmpty())
            return true;
        else {
            stack.clear();
            return false;
        }
    }
}