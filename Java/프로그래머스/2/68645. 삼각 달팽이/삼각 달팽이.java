import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int max = 0, number = 1, bottom = n, right = n, top = 0, count = 0;
        int[] position = new int[2];
        ArrayList<int[]> list = new ArrayList<>();
        
        for (int i=1; i<=n; i++) {
            list.add(new int[i]);
            max += i;
        }
        
        while (number <= max) {
            while (position[0] < bottom && number <= max && list.get(position[0])[position[1]] == 0) {
                list.get(position[0])[position[1]] = number++;
                position[0]++;
            }

            bottom--;
            position[0]--;
            position[1]++;
            
            while (position[1] < right && number <= max && list.get(position[0])[position[1]] == 0) {
                list.get(position[0])[position[1]] = number++;
                position[1]++;
            }

            right -= 2;
            position[1] -= 2;
            position[0]--;
            
            while (position[0] > top && number <= max && list.get(position[0])[position[1]] == 0) {
                list.get(position[0])[position[1]] = number++;
                position[0]--;
                position[1]--;
            }
            
            top++;
            position[0] += 2;
            position[1]++;
        }
        
        answer = new int[max];
        
        for (int[] line : list) {
            for (int num : line) {
                answer[count++] = num;
            }
        }
        
        return answer;
    }
}