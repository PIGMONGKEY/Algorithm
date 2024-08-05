import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int giftTime, receiveGift = 0;
        
        // gift point - 선물 지수
        HashMap<String, Integer> gp = new HashMap<>();
        // gift history - 선물 기록
        HashMap<String, HashMap<String, Integer>> gh = new HashMap<>();
        HashMap<String, Integer> temp;
        
        String[] t = {};
        
        for (String friend : friends) {
            temp = new HashMap<String, Integer>();
            for (String ff : friends) {
                if (friend.equals(ff))
                    continue;
                
                temp.put(ff, 0);
                gp.put(ff, 0);
            }
            gh.put(friend, temp);
        }
        
        for (String g : gifts) {
            t = g.split(" ");
            
            gp.put(t[0], gp.get(t[0]) + 1);
            gp.put(t[1], gp.get(t[1]) - 1);
            
            temp = gh.get(t[0]);
            temp.put(t[1], temp.get(t[1]) - 1);
            gh.put(t[0], temp);
            
            temp = gh.get(t[1]);
            temp.put(t[0], temp.get(t[0]) + 1);
            gh.put(t[1], temp);
        }
        
        for (int i=0; i<friends.length; i++) {
            temp = gh.get(friends[i]);
            for (int j=0; j<friends.length; j++) {
                if (i == j)
                    continue;
                giftTime = temp.get(friends[j]);
                if (giftTime == 0) {
                    receiveGift += gp.get(friends[i]) > gp.get(friends[j]) ? 1 : 0;
                } else
                    receiveGift += giftTime < 0 ? 1 : 0;
            }
            
            answer = Math.max(answer, receiveGift);
            receiveGift = 0;
        }
        
        return answer;
    }
}