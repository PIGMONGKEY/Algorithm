import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] array = new String[numbers.length];
        int sum = 0;
        
        for (int i=0; i<numbers.length; i++)
            array[i] = Integer.toString(numbers[i]);
        
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1, b = o2;
                
                if (o1.equals(o2))
                    return 0;
                
                for (int i=0; i<2; i++) {
                    a = a.concat(o1);
                    b = b.concat(o2);
                }
                
                return a.compareTo(b) * -1;
            }
        });
        
        for (String number : array) {
            answer = answer.concat(number);
            sum += Integer.parseInt(number);
        }
        
        if (sum == 0)
            answer = "0";
        
        return answer;
    }
}