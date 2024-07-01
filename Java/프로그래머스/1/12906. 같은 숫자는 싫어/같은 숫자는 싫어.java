import java.util.*;

public class Solution {
    public Object[] solution(int []arr) {
        LinkedList<Integer> stack = new LinkedList<>();
        
        stack.add(arr[0]);
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] != stack.peekLast()) {
                stack.add(arr[i]);
            }
        }

        return stack.toArray();
    }
}