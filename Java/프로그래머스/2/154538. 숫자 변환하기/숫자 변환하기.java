import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {        
        return bfs(x, y, n);
    }
    
    private int bfs(int x, int y, int n) {
        int curValue;
        int curCount;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Queue<Integer> valueQueue = new LinkedList<Integer>();
        Queue<Integer> countQueue = new LinkedList<Integer>();
        
        valueQueue.add(x);
        countQueue.add(0);
        
        while (!valueQueue.isEmpty()) {
            curValue = valueQueue.poll();
            curCount = countQueue.poll();
            
            if (curValue > y || map.containsKey(curValue))
                continue;
            else
                map.put(curValue, curCount);
            
            if (curValue == y)
                return curCount;
            
            valueQueue.add(curValue + n);
            valueQueue.add(curValue * 2);
            valueQueue.add(curValue * 3);
            
            countQueue.add(curCount + 1);
            countQueue.add(curCount + 1);
            countQueue.add(curCount + 1);
        }
        
        return -1;
    }
}