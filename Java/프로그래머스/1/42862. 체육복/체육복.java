class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        
        for (int i=0; i<n; i++) {
            if (i < lost.length)
                arr[lost[i] - 1] = arr[lost[i]-1] == 0 ? lost[i] * -1 : 0;
            if (i < reserve.length)
                arr[reserve[i] - 1] = arr[reserve[i]-1] == 0 ? reserve[i] : 0;
        }
        
        for (int i=0; i<n; i++) {
            if (arr[i] < 0) {
                if (i > 0 && arr[i-1] > 0) {
                    answer++;
                    arr[i-1] = 0;
                } else if (i < n-1 && arr[i+1] > 0) {
                    answer++;
                    arr[i+1] = 0;
                }
            } else
                answer++;
        }
        
        return answer;
    }
}