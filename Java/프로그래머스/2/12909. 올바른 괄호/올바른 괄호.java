import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        Stack<String> stack = new Stack<>();
        
        if (s.startsWith(")") || s.endsWith("(") || s.length() % 2 != 0) {
            return false;
        }
        
        for (String c : s.split("")) {
            if (c.equals("(")) {
                count++;
            } else {
                count--;
            }
            
            if (count < 0) return false;
        }

        return count == 0;
    }
}