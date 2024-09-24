class Solution {
    
    private static int[][] memo;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        memo = new int[triangle.length][];
        
        for (int i=0; i<triangle.length ;i++) {
            memo[i] = new int[i+1];
            for (int j=0; j<i+1; j++)
                memo[i][j] = -1;
        }
        
        answer = findBiggestWay(triangle, 0, 0, triangle.length - 1);
        
        return answer;
    }
    
    private int findBiggestWay(int[][] triangle, int line, int place, int maxLine) {
        int left, right;
        
        if (line == maxLine)
            return triangle[line][place];
        
        if (memo[line][place] != -1)
            return memo[line][place];
        
        left = findBiggestWay(triangle, line+1, place, maxLine);
        right = findBiggestWay(triangle, line+1, place+1, maxLine);
        
        memo[line][place] = Math.max(memo[line][place], Math.max(left, right) + triangle[line][place]);
        
        return memo[line][place];
    }
}