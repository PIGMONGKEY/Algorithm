class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        int left, right;
        int[] flags = new int[wires.length];
        
        for (int i=0; i<wires.length; i++) {
            left = func(wires, flags, i, wires[i][0], 0);
            right = func(wires, flags, i, wires[i][1], 0);
            
            if (answer >= Math.abs(left - right))
                answer = Math.abs(left - right);
        }
        
        return answer;
    }
    
    int func(int[][] wires, int[] flags, int cutWire, int curNode, int count) {
        for (int i=0; i<wires.length; i++) {
            if (i == cutWire || flags[i] > 0)
                continue;
            
            if (wires[i][0] == curNode) {
                flags[i]++;
                count = func(wires, flags, cutWire, wires[i][1], count + 1);
                flags[i]--;
            }
            else if (wires[i][1] == curNode) {
                flags[i]++;
                count = func(wires, flags, cutWire, wires[i][0], count + 1);
                flags[i]--;
            }
        }
        
        return count;
    }
}