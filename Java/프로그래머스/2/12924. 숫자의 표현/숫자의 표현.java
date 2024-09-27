class Solution {
    public int solution(int n) {
        int answer = 0, left = 1, right = 1, sum = 1;
        
        while (true) {
            if (sum <= n) {
                if (sum == n)
                    answer++;
                if (++right > n)
                    break;
                sum += right;
            } else {
                sum -= left++;
            }
        }
        
        return answer;
    }
}