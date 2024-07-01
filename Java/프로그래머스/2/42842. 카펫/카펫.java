class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int h, w, total;
        
        total = (brown + 4) / 2;
        
        for (w = (int) Math.ceil((double) total / 2.0); w < total; w++) {
            h = total - w;
            if ((h - 2) * (w - 2) == yellow) {
                answer = new int[2];
                answer[0] = w;
                answer[1] = h;
            }
        }
        
        return answer;
    }
}