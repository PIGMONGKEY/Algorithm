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
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() == '{')
                        stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() == '[')
                        stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (stack.peek() == '(')
                        stack.pop();
                    break;
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