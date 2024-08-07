class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr2Copy = new int[arr2[0].length][arr2.length];
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        int sum = 0, a = 0, b = 0;
        
        for (int i=0; i<arr2.length; i++)
            for (int j=0; j<arr2[i].length; j++)
                arr2Copy[j][i] = arr2[i][j];
        
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2Copy.length; j++) {
                for (int k=0; k<arr2Copy[j].length; k++) {
                    sum += arr1[i][k] * arr2Copy[j][k];
                }
                answer[a][b] = sum;
                sum = 0;
                b++;
            }
            a++;
            b = 0;
        }
        
        return answer;
    }
}