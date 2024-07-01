import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int temp;
        HashMap<String, Integer> hash = new HashMap<>();
        
        for (String name : participant) {
            if (hash.get(name) != null) {
                hash.replace(name, hash.get(name) + 1);
            } else {
                hash.put(name, 1);
            }
        }
        
        for (String name : completion) {
            if (hash.get(name) != null) {
                temp = hash.get(name);
                temp--;
                
                if (temp == 0) {
                    hash.remove(name);
                } else {
                    hash.replace(name, temp);
                }
            } else {
                answer = name;
                break;
            }
        }
        
        Iterator<String> it = hash.keySet().iterator();
        answer = it.next();
        
        return answer;
    }
}