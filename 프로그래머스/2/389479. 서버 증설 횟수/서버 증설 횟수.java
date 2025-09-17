import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int player, requiredServerCnt, answer = 0, curServerCnt = 0;
        int[] tempServerInfo;
        LinkedList<int[]> serverQueue = new LinkedList<>();
        
        for (int i=0; i<players.length; i++) {
            tempServerInfo = serverQueue.peekLast();
            
            if (tempServerInfo != null && tempServerInfo[1] == i) {
                tempServerInfo = serverQueue.pollLast();
                curServerCnt -= tempServerInfo[0];
            }
            
            player = players[i];
            requiredServerCnt = (player / m) - curServerCnt;
            
            if (requiredServerCnt <= 0)
                continue;
            
            serverQueue.push(new int[] { requiredServerCnt, i+k });
            curServerCnt += requiredServerCnt;
            answer += requiredServerCnt;
        }
        
        return answer;
    }
}