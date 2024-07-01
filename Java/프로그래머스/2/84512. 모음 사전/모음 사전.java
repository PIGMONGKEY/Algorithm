class Solution {
    int count = 0;
    public int solution(String word) {
        int answer = 0;
        String[] letters = {"A", "E", "I", "O", "U"};
        
        func(letters, word, "");
        answer = count;
        
        return answer;
    }
    
    boolean func(String[] letters, String answer, String word) {
        if (answer.equals(word))
            return true;
        
        if (word.length() >= 5)
            return false;
        
        for (int i=0; i<letters.length; i++) {
            count++;
            if (func(letters, answer, word.concat(letters[i])))
                return true;
        }
        
        return false;
    }
}