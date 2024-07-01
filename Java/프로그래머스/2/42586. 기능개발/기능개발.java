import java.util.LinkedList;

class Solution {
    public Object[] solution(int[] progresses, int[] speeds) {
        Object[] answer = {};
        int leftDays = 0, count = 0;
        Integer pollData = 0;
        final int FINISH = 100;
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++) {
            leftDays = ((FINISH - progresses[i]) % speeds[i] == 0) ? 
                (FINISH - progresses[i]) / speeds[i] : (FINISH - progresses[i]) / speeds[i] + 1;
            
            if (stack.isEmpty() || stack.peekLast() <= leftDays) {
                stack.add(leftDays);
            } else {
                stack.add(stack.peekLast());
            }
        }
        
        for (int i=0; i<speeds.length; i++) {
            while(true) {
                pollData = stack.pollFirst();
                count++;
                if (stack.peekFirst() != pollData || pollData == null) {
                    break;
                }
            }
            
            if (pollData != null) {
                result.add(count);
                count = 0;
            }
        }
        
        answer = result.toArray();
        
        return answer;
    }
}