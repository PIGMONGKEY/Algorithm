import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> set;
        
        for (String[] cloth : clothes) {
            set = map.getOrDefault(cloth[1], new HashSet<>());
            set.add(cloth[0]);
            map.put(cloth[1], set);
        }
        
        for (String key : map.keySet()) {
            answer *= map.get(key).size() + 1;
        }
        
        return answer - 1;
    }
}