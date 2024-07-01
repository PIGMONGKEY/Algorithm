class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = dfs(numbers, target, 0, 0, answer);
        
        return answer;
    }
    
    int dfs(int[] numbers, int target, int index, int sum, int answer) {
        int[] tempArr = {1, -1};
        
        if (index == numbers.length) {
            if (sum == target)
                return answer + 1;
            else
                return answer;
        }
        
        for (int n : tempArr) {
            answer = dfs(numbers, target, index + 1, sum + (numbers[index] * n), answer);
        }
        
        return answer;
    }
}