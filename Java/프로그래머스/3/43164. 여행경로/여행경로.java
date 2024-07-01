import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int j = 0;
        int[] used = new int[tickets.length];
        LinkedList<String> list = new LinkedList<>();
        String start = "";
        
        // 도착지 기준으로 알파벳 순서대로 정렬
        Arrays.sort(tickets, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });
        
        // 출발지 입력
        list.add("ICN");
        
        dfs(tickets, used, list, "ICN");
        
        answer = new String[list.size()];
        
        while (!list.isEmpty())
            answer[j++] = list.poll();
        
        return answer;
    }
    
    boolean dfs(String[][] tickets, int[] used, LinkedList<String> list, String cur) {
        boolean arrived = true;
        
        // 모든 티켓을 사용하면 true 리턴
        for (int n : used) {
            if (n < 1) {
                arrived = false;
                break;
            }
        }
        
        if (arrived)
            return true;
            
        
        // 현재 위치에서 갈 수 있는 곳을 차례대로 가봄
        for (int i=0; i<tickets.length; i++) {
            boolean doneFlag = false;
            
            // 이미 사용한 티켓 건너뜀
            if (used[i] > 0)
                continue;
            
            // 티켓 출발지가 현재 위치면 사용
            if (tickets[i][0].equals(cur)) {
                used[i]++;
                list.add(tickets[i][1]);
                doneFlag = dfs(tickets, used, list, tickets[i][1]);
                
                if (doneFlag)
                    return true;
                else {
                    used[i]--;
                    list.removeLast();
                }
            }
        }
        
        return false;
    }
}