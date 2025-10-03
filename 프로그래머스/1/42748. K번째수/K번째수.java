import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int i = 0;
        int[] answer = new int[commands.length];
        int[] target;
        
        for (int[] command : commands) {
            target = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(target);
            answer[i++] = target[command[2]-1];
        }
        
        return answer;
    }
}