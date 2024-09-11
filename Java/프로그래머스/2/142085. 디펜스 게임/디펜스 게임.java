import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int round = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        // 무적권 안 쓰고 갈 수 있을 때까지 전진
        while (round < enemy.length + 1 && n >= enemy[round - 1]) {
            n -= enemy[round - 1];
            pq.add(enemy[round - 1]);
            round++;
        }
        
        // 현제 라운드를 포함한 라운드 중 적 수가 가장 많은 라운드에 무적권 사용
        while (true) {
            if (round > enemy.length || (n < enemy[round - 1] && k <= 0))
                break;
            
            if (n >= enemy[round - 1]) {
                n -= enemy[round - 1];
                pq.add(enemy[round - 1]);
                round++;
            } else if (k > 0) {
                pq.add(enemy[round - 1]);
                n += pq.poll();
                n -= enemy[round - 1];
                round++;
                k--;
            }
        }
        
        return round - 1;
    }
}