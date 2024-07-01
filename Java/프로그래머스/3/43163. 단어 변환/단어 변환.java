import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0, count = 0;
        int[] flag = new int[words.length];
        ArrayList<String> wordsArray = new ArrayList<>();
        StringBuilder cur = new StringBuilder(begin);
        StringBuilder next;
        Queue<StringBuilder> queue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        
        for (String word : words)
            wordsArray.add(word);
        
        queue.offer(cur);
        countQueue.offer(count);
        
        while (!queue.isEmpty()) {
            cur = queue.poll();
            count = countQueue.poll();
            
            // cur이 target이랑 같은지 확인
            if (cur.toString().equals(target))
                return count;
            
            // 한 글자씩 바꿔서 queue에 추가
            for (int j=0; j<words.length; j++) {
                if (flag[j] > 0)
                    continue;
                
                String word = words[j];
                
                for (int i=0; i<target.length(); i++) {
                    if (cur.charAt(i) == target.charAt(i))
                        continue;
                    
                    next = new StringBuilder(cur.toString());
                    next.setCharAt(i, word.charAt(i));
                    
                    if (next.toString().equals(word)) {
                        flag[j]++;
                        queue.offer(next);
                        countQueue.offer(count + 1);
                    }
                }
            }
        }

        return answer;
    }
}