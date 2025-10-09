import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        ArrayList<String> words = new ArrayList<>();
        String[] letters = new String[] { "A", "E", "I", "O", "U" };
        
        rani("", words, letters);
        
        words.remove("");
        
        for (String letter : words) {
            answer++;
            if (letter.equals(word))
                break;
        }
        
        return answer;
    }
    
    private void rani(String cur_word, ArrayList<String> words, String[] letters) {
        words.add(cur_word);
        
        if (cur_word.length() >= 5)
            return;
        
        for (String letter : letters)
            rani(cur_word.concat(letter), words, letters);
    }
}