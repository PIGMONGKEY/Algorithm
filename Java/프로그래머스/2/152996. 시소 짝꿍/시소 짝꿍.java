import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int length = weights.length;
        
        int[][] memo = new int[3][length];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0; i<3; i++)
            for (int j=0; j<length; j++)
                memo[i][j] = weights[j] * (i + 2);
        
        for (int i=0; i<2; i++) {
            // 비교군 무게 map에 저장
            for (int j=0; j<length; j++)
                map.put(memo[i][j], map.getOrDefault(memo[i][j], 0) + 1);
            // 나머지 무게들 비교
            // map에 이미 저장되어 있으면 시소 짝꿍
            for (int k=i+1; k<3; k++)
                for (int l=0; l<length; l++)
                    if (map.getOrDefault(memo[k][l], 0) != 0)
                        answer += map.get(memo[k][l]);
            
            if (i == 0) {
                for (int m : map.values()) {
                    if (m > 1) {
                        for (int n=m-1; n>0; n--)
                            answer += n;
                    }
                }
            }
            // map 초기화
            map.clear();
        }
        
        return answer;
    }
}