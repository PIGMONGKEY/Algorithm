import java.util.*;

class Solution {
    private int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        findCode(n, 1, ans, q, new LinkedList<>());
        
        return answer;
    }
    
    private boolean checkAnswer(int[] ans, int[][] q, LinkedList<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int i=0; i<q.length; i++) {
            set.addAll(nums);
            for (int num : q[i])
                set.add(num);
            if (set.size() != 10 - ans[i])
                return false;
            set.clear();
        }
        
        return true;
    }
    
    private void findCode(int n, int start, int[] ans, int[][] q, LinkedList<Integer> nums) {
        if (nums.size() == 5) {
            if (checkAnswer(ans, q, nums))
                answer++;
        } else {
            for (int i=start; i<=n; i++) {
                nums.push(i);
                findCode(n, i+1, ans, q, nums);
                nums.poll();
            }
        }
    }
}