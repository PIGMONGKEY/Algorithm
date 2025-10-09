class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int width, height, sum = (brown / 2) + 2;
        
        for (height = 3; height <= sum / 2; height++) {
            for (width = height; width <= sum - height; width++) {
                if ((height - 2) * (width - 2) == yellow)
                    return new int[] { width, height };
            }
        }
        
        return answer;
    }
}