class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 2;
        
        while (answer == 0) {
            if (n % i == 1)
                answer = i;
            i++;
        }
        
        return answer;
    }
}