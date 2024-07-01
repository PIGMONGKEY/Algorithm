import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int weightSum = 0, answer = 0;
        Queue<Integer> bridgeQ = new LinkedList<>();
        
        for (int i=0; i<truck_weights.length; i++) {
            if (bridgeQ.size() >= bridge_length) {
                weightSum -= bridgeQ.poll();
            }
            
            weightSum += truck_weights[i];
            
            if (weightSum > weight) {
                weightSum -= truck_weights[i];
                for (int j=0; j<bridge_length - bridgeQ.size(); j++) {
                    bridgeQ.add(0);
                    answer++;
                }
                i--;
            } else {
                bridgeQ.add(truck_weights[i]);
                answer++;
            }
        }
        
        for (int i=0; i<bridge_length; i++)
            answer++;
        
        return answer;
    }
}