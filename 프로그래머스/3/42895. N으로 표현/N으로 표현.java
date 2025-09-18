import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        int[] counts = new int[32001];
        Arrays.fill(counts, Integer.MAX_VALUE);

        // 초기값: N 하나만 사용
        counts[N] = 1;

        // dp[i]: N을 i번 사용해서 만들 수 있는 값들의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>()); // dummy
        dp.add(new HashSet<>(Arrays.asList(N)));

        // i = 2 ~ 8까지 시도
        for (int i = 2; i <= 8; i++) {
            Set<Integer> curSet = new HashSet<>();

            // 1) 이어붙인 수 추가 (예: 55, 555, ...)
            int concat = concatN(N, i);
            if (concat <= 32000) {
                curSet.add(concat);
                counts[concat] = Math.min(counts[concat], i);
            }


            // 2) j + (i-j) 분할 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        int[] results = {
                            a + b,
                            a - b,
                            b - a,
                            a * b,
                            (b != 0 ? a / b : Integer.MAX_VALUE),
                            (a != 0 ? b / a : Integer.MAX_VALUE)
                        };
                        for (int r : results) {
                            if (r <= 0 || r > 32000) continue;
                            curSet.add(r);
                            counts[r] = Math.min(counts[r], i);
                        }
                    }
                }
            }

            dp.add(curSet);

            if (counts[number] != Integer.MAX_VALUE) {
                return counts[number];
            }
        }

        return -1;
    }

    private int concatN(int N, int times) {
        int v = 0;
        for (int i = 0; i < times; i++) {
            v = v * 10 + N;
        }
        return v;
    }
}
