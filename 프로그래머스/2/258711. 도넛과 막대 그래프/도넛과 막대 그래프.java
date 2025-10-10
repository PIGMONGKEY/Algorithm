// 도넛모양
// 도넛 순회 후 자기 자신으로 복귀

// 막대
// 나머지 모두 방문하는 정점 한 개 존재

// 8자
// 2n + 1 정점 / 2n + 2개 간선
// 크기 동일한 도넛 2개 결합한 모양

// 생성한 정점 번호, 도넛 수, 막대 수, 8자 수 반환

// 들어오는거 없이 나가기만 하면 생성한 정점
// 이 정점에서 나가는 간선이 닿는 정점을 시작으로 그래프 판별

import java.util.*;

class Solution {
    private final int STICK = 2;
    private final int DOU = 1;
    private final int EIGHT = 3;

    public int[] solution(int[][] edges) {
        int point = 1, type;
        int[] answer = new int[4];
        HashMap<Integer, ArrayList<Integer>> to = new HashMap<>();      // get(1) => 1에서 어디로 가는지
        HashMap<Integer, ArrayList<Integer>> from = new HashMap<>();    // get(1) => 어디서 1로 오는지
        ArrayList<Integer> start_points;
        
        for (int[] edge : edges) {
            if (!to.containsKey(edge[0]))
                to.put(edge[0], new ArrayList<>());
            if (!from.containsKey(edge[1]))
                from.put(edge[1], new ArrayList<>());
            
            to.get(edge[0]).add(edge[1]);
            from.get(edge[1]).add(edge[0]);
        }
        
        while (true) {
            if (!from.containsKey(point) && to.containsKey(point) && to.get(point).size() > 1)
                break;
            
            point++;
        }
        
        answer[0] = point;
        start_points = to.get(point);
        to.remove(point);

        for (int start_point : start_points) {
            type = getGraphType(start_point, to, from);
            switch (type) {
                case STICK:
                    answer[STICK]++;
                    break;
                case DOU:
                    answer[DOU]++;
                    break;
                case EIGHT:
                    answer[EIGHT]++;
            }
        }

        return answer;
    }
    
    private int getGraphType(int start_point, HashMap<Integer, ArrayList<Integer>> to, HashMap<Integer, ArrayList<Integer>> from) {
        int cur_point = start_point;
        boolean start_flag = false;

        while (true) {
            if (!to.containsKey(cur_point))
                return STICK;
            
            if (to.get(cur_point).size() > 1)
                return EIGHT;
            
            if (start_flag && cur_point == start_point)
                return DOU;
            
            start_flag = true;
            
            cur_point = to.get(cur_point).get(0);
        }
    }
}