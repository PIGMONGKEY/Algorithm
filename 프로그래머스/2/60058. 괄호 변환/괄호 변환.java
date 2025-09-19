import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        StringBuffer sb;
        Stack<Integer> stack;
        
        if (p.isBlank())
            return answer;
        
        sb = new StringBuffer(p);
        
        answer = correctParentheses(sb).toString();
        
        return answer;
    }
    
    private int[] divideString(StringBuffer sb) {
        int curCode, parenthesesCount = 0, isCorrectString = 1;
        
        for (int i=0; i<sb.length(); i++) {
            curCode = sb.codePointAt(i);
            
            parenthesesCount += curCode == 40 ? 1 : -1;
            
            if (parenthesesCount < 0)
                isCorrectString = 0;
            
            if (parenthesesCount == 0) 
                return new int[] { 0, i, isCorrectString };
        }
        
        return null;
    }
    
    private StringBuffer correctParentheses(StringBuffer sb) {
        int[] uInfo;
        StringBuffer nextSB, result;
        
        if (sb.length() == 0)
            return sb;
        
        uInfo = divideString(sb);
        nextSB = uInfo[1] + 1 >= sb.length() ? new StringBuffer("") : new StringBuffer(sb.substring(uInfo[1] + 1));

        if (uInfo[2] == 1) {
            result = new StringBuffer(sb.substring(0, uInfo[1] + 1));
            return result.append(correctParentheses(nextSB));
        }
        
        result = new StringBuffer("(");
        result.append(correctParentheses(nextSB));
        result.append(")");
        for (int i=1; i<uInfo[1]; i++)
            result.appendCodePoint(sb.codePointAt(i) == 40 ? 41 : 40);
        
        return result;
    }
}