import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] numberStrings = s.split(" ");
        
        // comparator를 사용하여 정렬
        Arrays.sort(numberStrings, (o1, o2) -> {
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        });
        
        // 오름차순으로 정렬된 배열을 돌며 처음과 마지막만 답변에 추가
        for (int i=0; i<numberStrings.length; i++) {
            if (i == 0)
                answer += numberStrings[i] + " ";
            if (i == numberStrings.length - 1)
                answer += numberStrings[i];
        }
        
        return answer;
    }
}