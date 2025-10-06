import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int a = 0, b = 0, c = 0, max = 0;
        
        int[] answer = {};
        int[] a_ans = new int[] { 1, 2, 3, 4, 5 };
        int[] b_ans = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] c_ans = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<answers.length; i++) {
            if (answers[i] == a_ans[i % 5])
                a++;
            if (answers[i] == b_ans[i % 8])
                b++;
            if (answers[i] == c_ans[i % 10])
                c++;
        }
        
        max = Math.max(a, Math.max(b, c));
        
        if (a == max)
            ans.add(1);
        if (b == max)
            ans.add(2);
        if (c == max)
            ans.add(3);
        
        answer = ans.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        return answer;
    }
}