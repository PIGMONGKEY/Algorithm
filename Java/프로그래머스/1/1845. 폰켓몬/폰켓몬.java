import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for (int num : nums) {
            if (hash.get(num) != null) {
                hash.replace(num, hash.get(num) + 1);
            } else {
                hash.put(num, 1);
            }
        }
        
        answer = hash.size() > max ? max : hash.size();
        
        return answer;
    }
}