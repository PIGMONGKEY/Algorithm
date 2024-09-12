class Solution {
    public int[] solution(int[][] arr) {
        int maxQuadSize = arr.length;
        int curQuadSize = maxQuadSize;
        int curStatus;
        int[] quadStartPoint = new int[2];
        int[] quadCounts = new int[2];
        
        // 쿼드 사이즈가 1이 될때까지 반복
        while (curQuadSize > 0) {
            
            // 압축 가능 확인 후 압축 가능하면 count 추가
            // 다음 쿼드 시작 위치 찾은 후 유효하면 계속 진행
            // 유효하지 않으면 멈추고 쿼드 사이즈 축소
            // 탈출 시 쿼드 시작 위치는 [-1, -1]
            while (true) {                
                curStatus = checkQuad(arr, quadStartPoint, curQuadSize);
                
                if (curStatus != -1)
                    quadCounts[curStatus]++;
                
                if (!findNextQuadStartPoint(quadStartPoint, curQuadSize, maxQuadSize))
                    break;
            }
            
            findNextQuadStartPoint(quadStartPoint, curQuadSize, maxQuadSize);
            curQuadSize /= 2;
        }
        
        return quadCounts;
    }
    
    // 다음 쿼드 시작좌표를 찾음
    // 다음 쿼드 시작점이 유효하지 않은 경우, false 리턴
    // 유효하지 않은 쿼드 시작점이 들어온 경우, [0, 0]으로 변경 후 true 리턴
    private boolean findNextQuadStartPoint(int[] quadStartPoint, int curQuadSize, int maxQuadSize) {
        int nextX, nextY;
        
        if (quadStartPoint[0] == -1) {
            quadStartPoint[0] = 0;
            quadStartPoint[1] = 0;
            
            return true;
        }
        
        nextX = quadStartPoint[0] + curQuadSize;
        nextY = quadStartPoint[1] + curQuadSize;
        
        if (nextX >= maxQuadSize) {
            if (nextY >= maxQuadSize) {
                quadStartPoint[0] = -1;
                quadStartPoint[1] = -1;
                return false;
            } else {
                quadStartPoint[0] = 0;
                quadStartPoint[1] = nextY;
                return true;
            }
        } else {
            quadStartPoint[0] = nextX;
            return true;
        }
    }
    
    // 압축 가능한지 확인
    // quadStartPoint의 숫자와 비교
    // 만약 다른 숫자를 만나면 return -1;
    // 압축 가능하면 해당 숫자 return
    // 압축 가능하면 압축 된 부분은 1로 압축이면 2로, 0으로 압축이면 -1로 변경
    private int checkQuad(int[][] arr, int[] quadStartPoint, int curQuadSize) {
        int x = quadStartPoint[0];
        int y = quadStartPoint[1];
        int num = arr[x][y];
        int fillNum = num == 1 ? 2 : -1;
        
        if (num == 2 || num == -1)
            return -1;
         
        for (int i=0; i<curQuadSize; i++) {
            for (int j=0; j<curQuadSize; j++) {
                if (arr[x][y] != num)
                    return -1;
                x++;
            }
            x = quadStartPoint[0];
            y++;
        }
        
        x = quadStartPoint[0];
        y = quadStartPoint[1];
        
        for (int i=0; i<curQuadSize; i++) {
            for (int j=0; j<curQuadSize; j++)
                arr[x++][y] = fillNum;
            x = quadStartPoint[0];
            y++;
        }
        
        return num;
    }
}