import java.util.*;

class Solution {    
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE, i=0, left = 0, right = 0;
        long max = 0l, sum = 0l;
        int[] allNumbers = new int[queue1.length + queue2.length];
        ArrayList<int[]> list = new ArrayList<>();
        
        for (i=0; i<queue1.length; i++) {
            allNumbers[i] = queue1[i];
            allNumbers[i+queue1.length] = queue2[i];
            max += (long) queue1[i];
            max += (long) queue2[i];
        }
        
        max /= 2;
        sum += allNumbers[right];
        
        while (true) {
            if (sum == max) {
                list.add(new int[] {left, right++});
                if (right >= allNumbers.length)
                    break;
                sum += (long) allNumbers[right];
            } else if (sum < max) {
                if (++right >= allNumbers.length)
                    break;
                
                sum += (long) allNumbers[right];
            }
            else {
                sum -= (long) allNumbers[left];
                left++;
                if (left > right || left >= allNumbers.length)
                    break;
            }
        }
        
        if (list.isEmpty())
            return -1;
        
        for (int[] lr : list) {            
            answer = Math.min(answer, getCount(lr[0], lr[1], queue1.length));
        }
        
        return answer;
    }
    
    private int getCount(int left, int right, int q1Length) {
        int count = 0;
        
        if (left >= q1Length) {
            if (right == q1Length * 2 - 1)
                count += left - q1Length;
            else {
                count += q1Length;
                count += (left - q1Length) * 2;
                count += right - left + 1;
            }
        } else {
            if (right >= q1Length) {
                count += left;
                count += right - (q1Length - 1);
            } else {
                if (right == q1Length - 1)
                    count += left;
                else {
                    count += left * 2;
                    count += q1Length;
                    count += right - left + 1;
                }
            }
        }
        
        return count;
    }
}