class Solution {
    public long solution(int k, int d) {
        long answer = 0, x = 0, y = 0, dist = (long) d * (long) d;
        
        while (true) {
            x = (long) Math.sqrt((double) (dist - (y * y)));
            answer += (long) (x / k) + 1L;
            y += k;
            
            if (y > d)
                break;
        }
        
        return answer;
    }
}