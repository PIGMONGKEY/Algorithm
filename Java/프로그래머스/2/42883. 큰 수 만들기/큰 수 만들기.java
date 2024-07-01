import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int i, answerLength = number.length() - k;
        char c;
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        list.push(number.charAt(0));

        for (i=1; i<number.length(); i++) {
            c = number.charAt(i);
            
            while (list.size() > 0 && k > 0 && (int) list.peek() < (int) c) {
                list.pop();
                k--;
            }

            list.push(c);
        }

        while (!list.isEmpty() && sb.length() < answerLength)
            sb.append(list.pollLast());

        return sb.toString();
    }
}