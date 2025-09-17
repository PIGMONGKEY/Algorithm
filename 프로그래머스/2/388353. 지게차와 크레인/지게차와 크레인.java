import java.util.*;
import java.util.stream.*;

class Solution {
    private boolean[][] visited;
    
    public int solution(String[] storage, String[] requests) {
        int code, answer = 0;
        int h = storage.length;
        int w = storage[0].length();
        int totalCnt = h * w;
        int[] requestCodes;
        int[][] map = new int[h][w];
        HashMap<Integer, ArrayList<int[]>> hash = new HashMap<>();
        ArrayList<int[]> tempArrayList;
        LinkedList<int[]> deleteQueue = new LinkedList<>();
        
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                code = storage[i].codePointAt(j);

                if (!hash.containsKey(code))
                    hash.put(code, new ArrayList<int[]>());

                tempArrayList = hash.get(code);
                tempArrayList.add(new int[] { i, j });
            }
        }
        
        for (String request : requests) {
            requestCodes = request.codePoints().toArray();
            tempArrayList = hash.get(requestCodes[0]);

            if (tempArrayList == null || tempArrayList.isEmpty())
                continue;
            
            if (requestCodes.length > 1) {
                for (int[] pos : tempArrayList)
                    map[pos[0]][pos[1]]--;

                totalCnt -= tempArrayList.size();
                tempArrayList.clear();

                continue;
            }

            for (int[] pos : tempArrayList) {
                if (map[pos[0]][pos[1]] != 0)
                    continue;

                visited = new boolean[h][w];

                if (checkOuter(pos[1], pos[0], h, w, map, true))
                    deleteQueue.push(pos);
            }
            
            totalCnt -= deleteQueue.size();
            
            while (!deleteQueue.isEmpty()) {
                int[] pos = deleteQueue.poll();
                System.out.println(pos[0] + " " + pos[1]);
                tempArrayList.remove(pos);
                map[pos[0]][pos[1]]--;
            }
        }
        
        return totalCnt;
    }
    
    private boolean checkOutRange(int small, int big, int target) {
        if (target >= big || target < small)
            return true;
        
        return false;
    }
    
    private boolean checkOuter(int x, int y, int h, int w, int[][] map, boolean isFisrt) {
        boolean top, bottom, left, right;
        
        if (checkOutRange(0, w, x) || checkOutRange(0, h, y))
            return true;

        if (visited[y][x] || (map[y][x] == 0 && !isFisrt))
            return false;
        
        visited[y][x] = true;
        
        top = checkOuter(x, y-1, h, w, map, false);
        bottom = checkOuter(x, y+1, h, w, map, false);
        left = checkOuter(x-1, y, h, w, map, false);
        right = checkOuter(x+1, y, h, w, map, false);
        
        return top || bottom || left || right;
    }
}