class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int count = 0;
        int c = 0;
        
        for (char a : Integer.toBinaryString(n).toCharArray())
            if (a == '1')
                count++;
        
        while (true) {
            for (char a : Integer.toBinaryString(answer).toCharArray())
                if (a == '1')
                    c++;
            
            if (c == count)
                break;
            answer++;
            c = 0;
        }
        
        return answer;
    }
}