class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int deleteCount = 0, transCount = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        
        // 문자열 길이가 1이 될 때까지 반복
        while (stringBuilder.length() != 1) {
            transCount++;
            
            // 0을 모두 제거
            for (int i=0; i<stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == '0') {
                    stringBuilder.deleteCharAt(i);
                    deleteCount++;
                    i--;
                }
            }
            
            // StringBuilder 내용 교체
            // StringBuilder 길이를 이진수로 변환하여 교체
            stringBuilder.replace(
                0, 
                stringBuilder.length(), 
                Integer.toBinaryString(stringBuilder.length())
            );
        }
        
        answer = new int[] {transCount, deleteCount};
        
        return answer;
    }
}