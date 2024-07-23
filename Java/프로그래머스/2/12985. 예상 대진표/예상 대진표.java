class Solution {
    public int solution(int n, int a, int b) {
        int curA = a > b ? b - 1 : a - 1;
        int curB = a > b ? a - 1 : b - 1;
        int round = 1;
        
        while (curA != curB) {
            curA /= 2;
            curB /= 2;
            round++;
        }
        
        return round - 1;
    }
}