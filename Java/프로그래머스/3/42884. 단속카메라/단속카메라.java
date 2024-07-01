import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int minOut = routes[0][1], answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        Arrays.sort(routes, (o1, o2) -> { return o1[1] - o2[1]; });
        
        stack.push(routes[0][1]);
        
        for (int i=1; i<routes.length; i++) {
            if (routes[i][0] > stack.peek())
                stack.push(routes[i][1]);
        }
        
        answer = stack.size();
        
        return answer;
    }
}