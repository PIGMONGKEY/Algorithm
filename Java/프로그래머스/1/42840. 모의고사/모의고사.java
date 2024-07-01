import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] patterns = {{1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int a = 0, b = 0, c = 0, index = 0, max;
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == patterns[0][i % 5])
                a++;
            if (answers[i] == patterns[1][i % 8])
                b++;
            if (answers[i] == patterns[2][i % 10])
                c++;
        }
        
        max = a > b ? a : b;
        max = max > c ? max : c;
        
        if (max == a)
            list.add(1);
        if (max == b)
            list.add(2);
        if (max == c)
            list.add(3);
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}