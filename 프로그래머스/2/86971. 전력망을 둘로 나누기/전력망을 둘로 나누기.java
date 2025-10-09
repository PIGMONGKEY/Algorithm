import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int tree_size;
        
        HashMap<Integer, ArrayList<int[]>> hash = new HashMap<>();
        
        for (int i=1; i<=n; i++)
            hash.put(i, new ArrayList<>());
        
        // [연결된 송전탑, wire번호]
        // 3 => [[4, 1], [2, 2]]
        for (int i=0; i<wires.length; i++) {
            hash.get(wires[i][0]).add(new int[] { wires[i][1], i });
            hash.get(wires[i][1]).add(new int[] { wires[i][0], i });
        }
        
        for (int i=0; i<wires.length; i++) {
            tree_size = getSeperatedTreeCount(wires, i, hash, new HashSet<Integer>(), wires[i==0 ? 1 : 0][0]);
            answer = Math.min(answer, Math.abs(tree_size - Math.abs((n-tree_size))));
        }
        
        return answer;
    }
    
    private int getSeperatedTreeCount(int[][] wires, int disconnected, HashMap<Integer, ArrayList<int[]>> hash, HashSet<Integer> tree, int next) {
        if (hash.get(next).isEmpty())
            return tree.size();
        
        for (int[] n : hash.get(next)) {
            if (n[1] == disconnected || tree.contains(n[0]))
                continue;
            
            tree.add(n[0]);
            getSeperatedTreeCount(wires, disconnected, hash, tree, n[0]);
        }
        
        return tree.size();
    }
}