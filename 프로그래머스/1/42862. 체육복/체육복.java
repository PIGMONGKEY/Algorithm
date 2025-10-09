class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int left, right, answer = 0;
        int[] losts = new int[n];
        int[] reserves = new int[n];
        
        for (int l : lost)
            losts[l-1] = 1;
        
        for (int r : reserve) {
            if (losts[r-1] == 1) {
                reserves[r-1] = 0;
                losts[r-1] = 0;
            } else
                reserves[r-1] = 1;
        }
        
        for (int i=0; i<n; i++) {
            if (losts[i] == 0) {
                answer++;
                continue;
            }

            left = i - 1;
            right = i + 1;
            
            if (left >= 0 && reserves[left] == 1) {
                reserves[left] = 0;
                answer++;
            } else if (right < n && reserves[right] == 1) {
                reserves[right] = 0;
                answer++;
            }
        }        
        
        return answer;
    }
}