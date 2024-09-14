import java.util.*;

class Solution {
    
    private static Stack<Integer>[] stack;
    private static ArrayList<int[]> list;
    
    public int[][] solution(int n) {
        int positionValue = 0;
        int cur21Position = 0;
        int next21Position, from = -1, to = -1, temp = 0;
        int[][] answer = {};
        
        stack = new Stack[3];
        list = new ArrayList<int[]>();
        
        // 초기화
        // 스택 배열 초기화
        for (int i=0; i<3; i++)
            stack[i] = new Stack<Integer>();
        
        // 첫번째 봉에 값 넣기
        for (int i=n; i>0; i--)
            stack[0].push(i);
        
        // 21 위치 증감자 초기화
        if (n % 2 == 0)
            positionValue = -1;
        else
            positionValue = 1;
        
        // 규칙
        // n이 5일때 각 판을 1, 2, 3, 4, 5로 정하고, 이는 각 판의 크기를 의미하도록 정의한다.
        // 그 중 1, 2를 하나의 블럭으로 간주하면, 이 블럭은 일정한 규칙에 따라 움직인다.
        // n이 짝수일때는 1, 3, 2 순서대로 움직이고,
        // n이 홀수일때는 1, 2, 3 순서대로 움직인다.
        // 이 블럭을 옮기고 나머지 판을 한 개씩 옮기는 과정을 반복하여 문제를 해결한다.
        while (true) {
            // 21 블럭을 옮긴다.
            next21Position = getNext21Position(cur21Position, positionValue);
            move21ToTarget(next21Position, cur21Position);
            cur21Position = next21Position;
            
            if (stack[2].size() == n)
                break;
            
            // 21블럭을 옮긴 후 21블럭을 옮긴 자리를 제외 하고, 나머지 봉에서 한 개를 옮김
            // 비어있는 봉이 있으면 해당 봉으로 옮기고,
            // 비어있는 봉이 없으면, 꼭대기가 더 큰 쪽으로 옮긴다.
            
            // 옮길 자리를 찾는 2가지 방법
            // 있는곳에서 없는 곳으로
            for (int i=0; i<3; i++) {                
                if (stack[i].isEmpty()) {
                    to = i;
                    from = 3 - (to + cur21Position);
                    break;
                }
            }
            
            // 아니면 작은 곳에서 큰 곳으로
            if (to == -1) {            
                for (int i=0; i<3; i++) {
                    if (i == cur21Position)
                        continue;
                    if (stack[i].peek() > temp) {
                        temp = stack[i].peek();
                        to = i;
                    }
                }
                
                from = 3 - (to + cur21Position);
            }
            
            // 맨 위 1개를 옮긴다.
            stack[to].push(stack[from].pop());
            list.add(new int[] {from + 1, to + 1});
            
            // 초기화
            to = -1;
            from = -1;
            temp = 0;
        }
        
        answer = new int[list.size()][2];
        
        for (int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        
        return answer;
    }
    
    // 21 블럭을 target으로 옮긴다.
    private void move21ToTarget(int target, int from) {
        int temp = -1;
        
        switch (target + from) {
            case 1:
                temp = 2;
                break;
            case 2:
                temp = 1;
                break;
            case 3:
                temp = 0;
                break;
        }
        
        stack[temp].push(stack[from].pop());
        list.add(new int[] {from + 1, temp + 1});
        
        stack[target].push(stack[from].pop());
        list.add(new int[] {from + 1, target + 1});
        
        stack[target].push(stack[temp].pop());
        list.add(new int[] {temp + 1, target + 1});
    }
    
    // 다음 21블럭 위치를 찾는다.
    private int getNext21Position(int cur, int positionValue) {
        cur += positionValue;
        
        if (cur > 2)
            cur = 0;
        if (cur < 0)
            cur = 2;
        
        return cur;
    }
}