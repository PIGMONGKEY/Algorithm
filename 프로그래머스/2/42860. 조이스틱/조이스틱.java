class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 세로 이동 합
        for (int i = 0; i < n; i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }

        // 가로 이동 최소값 계산 (초기값: 오른쪽으로 쭉 이동)
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            // 다음 인덱스부터 연속된 'A'를 건너뛴다
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            // i에서 되돌아가거나, 오른쪽으로 가는 등 여러 조합의 최소값 후보 계산
            move = Math.min(move, i + n - next + Math.min(i, n - next));
        }

        return answer + move;
    }
}
