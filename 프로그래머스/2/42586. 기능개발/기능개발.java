import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int curP, day;
        int[] answer = {};
        Stack<int[]> stack = new Stack<>();
        
        for (int i=0; i<progresses.length; i++) {
            curP = progresses[i];
            day = calculateDay(curP, speeds[i]);
            
            if (!stack.isEmpty() && stack.peek()[0] >= day)
                stack.peek()[1]++;
            else
                stack.push(new int[] {day, 1});
        }
        
        answer = new int[stack.size()];
        
        for (int i=stack.size()-1; i>=0; i--)
            answer[i] = stack.pop()[1];
        
        return answer;
    }
    
    private int calculateDay(int prog, int speed) {
        int left = 100 - prog;
        return (left % speed == 0 ? left / speed : (left / speed) + 1);
    }
}