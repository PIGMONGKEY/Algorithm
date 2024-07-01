import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int phone_length;
        HashMap<Integer, Set<String>> hash = new HashMap<>();
        HashSet<String> phones;
        
        for (String phone : phone_book) {
            phone_length = phone.length();
            
            if (hash.containsKey(phone_length)) {
                if (!hash.get(phone_length).add(phone)) {
                    return false;
                }
            } else {
                phones = new HashSet<>();
                if (!phones.add(phone)) {
                    return false;
                }
                hash.put(phone_length, phones);
            }
        }
        
        for (String phone : phone_book) {
            for (Integer key : hash.keySet()) {
                if (phone.length() <= key) {
                    continue;
                }
                
                if (hash.get(key).contains(phone.substring(0, key))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}