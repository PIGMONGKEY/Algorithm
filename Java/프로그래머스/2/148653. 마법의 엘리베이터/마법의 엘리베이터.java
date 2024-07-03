class Solution {    
    public int solution(int storey) {
        int answer = 0;
        int divideValue = 1;    // 나누는 값
        int dividedResult = Integer.MAX_VALUE;  // 나눈 결과값
        
        // 1의 자리부터 0으로 맞추며 올라감
        // 5보다 크면 더하여 10을 만들고
        // 5보다 작으면 빼서 0을 만듦
        while (storey > 0) {
            dividedResult = (storey % (int) Math.pow(10, divideValue)) / (int) Math.pow(10, divideValue - 1);
            
            if (dividedResult > 5) {
                answer += 10 - dividedResult;
                storey += (10 - dividedResult) * (int) Math.pow(10, divideValue - 1);
            } else if (dividedResult < 5) {
                answer += dividedResult;
                storey -= dividedResult * (int) Math.pow(10, divideValue - 1);
            } else {
                answer += dividedResult;
                if ((storey % (int) Math.pow(10, divideValue + 1)) / (int) Math.pow(10, divideValue) > 4)
                    storey += (10 - dividedResult) * (int) Math.pow(10, divideValue - 1);
                else
                    storey -= dividedResult * (int) Math.pow(10, divideValue - 1);
            }
            
            divideValue++;
        }
        
        return answer;
    }
    
    
}