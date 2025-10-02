import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
//         on_bridge_weight, 
        int obWeight = 0, curTruckIdx = 0, curTruckWeight = truck_weights[0];
        LinkedList<int[]> bridge = new LinkedList<>();
        
        while (!bridge.isEmpty() || curTruckIdx < truck_weights.length) {            
            time++;
            
            if (!bridge.isEmpty() && bridge.peekLast()[1] == time)
                obWeight -= bridge.pollLast()[0];
            
            if (curTruckIdx >= truck_weights.length || obWeight+truck_weights[curTruckIdx] > weight)
                continue;
            
            bridge.push(new int[] {truck_weights[curTruckIdx], time+bridge_length});
            obWeight += truck_weights[curTruckIdx];
            curTruckIdx++;
        }
        
        
        return time;
    }
}