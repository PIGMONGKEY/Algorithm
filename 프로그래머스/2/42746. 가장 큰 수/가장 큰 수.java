import java.util.*;
import java.util.stream.*;
import java.math.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1, s2 = o2;
                
                if (o1.equals(o2))
                    return 0;
                
                for (int i=0; i<2; i++) {
                    s1 = s1.concat(o1);
                    s2 = s2.concat(o2);
                }
                
                return s1.compareTo(s2) * -1;
            }
        };
        
        answer = Arrays.stream(numbers)
            .mapToObj((item) -> Integer.toString(item))
            .sorted(comp)
            .collect(Collectors.joining());
        
        if (answer.charAt(0) == '0')
            answer = "0";
        
        return answer;
    }
}