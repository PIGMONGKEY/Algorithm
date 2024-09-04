class Solution {
    public long[] solution(long[] numbers) {
        int index;
        
        long[] answer = new long[numbers.length];
        
        StringBuilder sb;
        
        // 2진수로 변환 후 맨 앞에 0을 붙임
        // 앞에서부터 만나는 0 중, 가장 마지막 0을 1로 변환
        // 위에서 변환한 인덱스가 2진수의 마지막 자리가 아니라면
        // 다음 인덱스를 0으로 변환
        for (int i=0; i<numbers.length; i++) {
            sb = new StringBuilder(Long.toString(numbers[i], 2));
            sb.insert(0, 0);
            
            index = sb.lastIndexOf("0");
            sb.setCharAt(index, '1');
            if (index != sb.length() - 1)
                sb.setCharAt(index + 1, '0');
            
            answer[i] = Long.valueOf(sb.toString(), 2);
        }
        
        return answer;
    }
}