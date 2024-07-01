import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int num, place = 0;
        int[] answer = {};
        LinkedList<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>((o1, o2) -> {return o1 - o2;});
        
        for (String operation : operations) {
            num = Integer.parseInt(operation.substring(2));
            System.out.println(num);
            if (operation.startsWith("I")) {
                list.add(num);
            } else if (num > 0) {
                queue.clear();
                queue.addAll(list);
                queue.poll();
                list.clear();
                list.addAll(queue);
            } else {
                reverseQueue.clear();
                reverseQueue.addAll(list);
                reverseQueue.poll();
                list.clear();
                list.addAll(reverseQueue);
            }
        }
        
        if (list.size() < 1) {
            answer = new int[] {0, 0};
        } else {
            queue.addAll(list);
            reverseQueue.addAll(list);
            answer = new int[] {queue.poll(), reverseQueue.poll()};
        }
        
        return answer;
    }
}