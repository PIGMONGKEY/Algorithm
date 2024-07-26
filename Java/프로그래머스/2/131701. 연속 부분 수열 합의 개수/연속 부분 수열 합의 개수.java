import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int curSum = 0;
        int curPlace = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0; i<elements.length; i++) {
            for (int j=0; j<elements.length-1; j++) {
                curPlace = (i + j) % elements.length;
                curSum += elements[curPlace];
                set.add(curSum);
            }
            curSum = 0;
        }
        
        answer = set.size() + 1;
        
        return answer;
    }
}