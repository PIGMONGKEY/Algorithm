# 재생수 / 장르 내 재생수 / 고유번호 낮은 순
# hash1 = 장르=>[재생수, 넘버]
# hash2 = 장르=>총재생수
# hash2.values sort
# hash1 순서대로
def solution(genres, plays)
    answer = []
    
    hash = { }
    play_count_hash = { }
    
    plays.each_with_index do |play, index|
        genre = genres[index]
        
        hash[genre] = [] unless hash.has_key? genre
        play_count_hash[genre] = 0 unless play_count_hash.has_key? genre
        
        hash[genre] << [play, index]
        play_count_hash[genre] += play
    end
    
    play_counts = play_count_hash.to_a.sort! { |o1, o2| o2[1] - o1[1] }
    
    play_counts.each do |pc|
        key = pc[0]
        play_records = hash[key]
        
        if play_records.size < 2
            answer << play_records.first[1]
            next
        end
        
        play_records.sort! do |o1, o2|
            if o1[0] > o2[0]
                -1
            elsif o2[0] > o1[0]
                1
            else
                o1[1] - o2[1]
            end
        end
        
        answer << play_records[0][1]
        answer << play_records[1][1]
    end
    
    return answer
end