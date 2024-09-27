class Solution {
    public int solution(int n) {
        int answer = 0, left = 0, right = 0, sum = 1;
        int[] arr = new int[n];
        
        for (int i=0; i<n; i++)
            arr[i] = i+1;
        
        while (true) {
            if (sum == n) {
                answer++;
                if (++right >= n)
                    break;
                sum += arr[right];
            } else if (sum < n) {
                if (++right >= n)
                    break;
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        
        return answer;
    }
}