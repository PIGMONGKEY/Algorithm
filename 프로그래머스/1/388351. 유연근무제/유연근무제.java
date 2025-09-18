class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int today, time, count = 0;
        
        for (int i=0; i<schedules.length; i++) {
            today = startday;
            count = 0;
            for (int j=0; j<7; j++) {
                today = today > 7 ? today - 7 : today;
                time = schedules[i] % 100 + 10 >= 60 ? ((schedules[i] / 100) + 1) * 100 + schedules[i] % 100 + 10 - 60 : schedules[i] + 10;

                if (today != 6 && today != 7 && timelogs[i][j] > time)
                    break;
                
                count++;
                today++;
            }
            
            if (count == 7)
                answer++;
        }
        
        return answer;
    }
}