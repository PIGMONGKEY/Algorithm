class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(target, 0, 0, numbers);
    }
    
    private int dfs(int target, int sum, int index, int[] numbers) {
        int count = 0;
        
        if (index == numbers.length) {
            if (sum == target)
                return 1;
            else
                return 0;
        }
        
        count += dfs(target, sum + numbers[index], index + 1, numbers);
        count += dfs(target, sum + numbers[index] * -1, index + 1, numbers);
        
        return count;
    }
}