import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int[] tempArray = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int[] command : commands) {
            tempArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(tempArray);
            list.add(tempArray[command[2] - 1]);
        }
        
        answer = list
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}