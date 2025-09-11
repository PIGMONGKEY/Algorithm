class Solution {
    public int solution(int[] stones, int k) {
        int tempMid, mid, start = Integer.MAX_VALUE, end = Integer.MIN_VALUE, answer = 0;
        
        for (int stone : stones) {
            start = stone <= start ? stone : start;
            end = stone >= end ? stone : end;
        }
        
        return findPeopleCnt(start - 1, 1, end + 1, k, stones);
    }
    
    private boolean crossCheck(int peopleCnt, int k, int[] stones) {
        int jumpCnt = 0;
        int stoneRemain;
        
        for (int stone : stones) {
            stoneRemain = stone - peopleCnt + 1;
            
            if (stoneRemain <= 0) {
                if (++jumpCnt >= k)
                    return false;
            } else
                jumpCnt = 0;
        }
        
        return true;
    }
    
    private int findPeopleCnt(int start, int prevMid, int end, int k, int[] stones) {
        int mid = (start + end) / 2;
        int result;
        
        if (mid <= start || mid >= end)
            return prevMid;
        
        if (crossCheck(mid, k, stones)) {
            result = findPeopleCnt(mid, mid, end, k, stones);
            result = Math.max(mid, result);
        } else {
            result = findPeopleCnt(start, mid, mid, k, stones);
            result = result == mid ? prevMid : result;
        }
        
        return result;
    }
}