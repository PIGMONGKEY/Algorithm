class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n % 2 == 1)
            return 2;
        
        for (int i=n-1; i>2; i=i-2) {
            if (n % i == 1)
                answer = i;
        }
        
        return answer;
    }
}