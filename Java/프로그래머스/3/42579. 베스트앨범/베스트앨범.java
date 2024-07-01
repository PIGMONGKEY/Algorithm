import java.util.*;
import java.util.stream.*;

class Solution {
    public Object[] solution(String[] genres, int[] plays) {
        Object[] answer = {};
        int totalPlay = 0;
        int queueSize = 0;
        LinkedList<Song> list = new LinkedList<>();
        HashMap<Integer, String> totalPlays = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i=0; i<genres.length; i++) {
            list.add(new Song(genres[i], plays[i], i));
        }
        
        for (String key : Arrays.stream(genres).distinct().toArray(String[]::new)) {
            totalPlay = list.stream()
                           .filter(song -> song.getGenre().equals(key))
                           .map(Song::getPlay)
                           .reduce(0, Integer::sum);
            
            totalPlays.put(totalPlay, key);
            queue.add(totalPlay);
        }
        
        queueSize = queue.size();
        for (int i=0; i<queueSize; i++) {
            String genre = totalPlays.get(queue.poll());
            list.stream()
                .filter(song -> song.getGenre().equals(genre))
                .sorted((a, b) -> { return a.getPlay() != b.getPlay() ? b.getPlay() - a.getPlay() : a.getNumber() - b.getNumber(); })
                .map(Song::getNumber)
                .limit(2)
                .collect(Collectors.toList())
                .forEach(data -> result.add(data));
        }
        
        answer = result.toArray();
        
        return answer;
    }
    
    private class Song {
        private String genre;
        private int play;
        private int number;
        
        public Song(String g, int p, int n) {
            this.genre = g;
            this.play = p;
            this.number = n;
        }
        
        public String getGenre() { return this.genre; }
        public int getPlay() { return this.play; }
        public int getNumber() { return this.number; }
    }
}