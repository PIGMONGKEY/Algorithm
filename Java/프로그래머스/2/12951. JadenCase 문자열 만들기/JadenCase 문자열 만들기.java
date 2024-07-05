class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirstChar = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                isFirstChar = true;
                sb.append(c);
                continue;
            }
            
            if (isFirstChar && (c >= 'A' && c <= 'z'))
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
            
            isFirstChar = false;
        }
        
        answer = sb.toString();
        
        return answer;
    }
}