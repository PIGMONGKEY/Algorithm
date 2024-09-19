class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int before = 1;
        int aCount = 0;

        for (int i=0; i<stations.length; i++) {
            aCount = stations[i] - w - before;
            before = stations[i] + w + 1;
            if (aCount > 0)
                answer += Math.ceil((double) aCount / (double) (w * 2 + 1));
        }
        
        if (before <= n) {
            aCount = n - before + 1;
            if (aCount > 0)
                answer += Math.ceil((double) aCount / (double) (w * 2 + 1));
        }

        return answer;
    }
}