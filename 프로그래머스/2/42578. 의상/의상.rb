def solution(clothes)
    answer = 1
    hash = { }
    
    clothes.each do |cloth|
        hash[cloth[1]] = 1 unless hash.has_key? cloth[1]
        hash[cloth[1]] += 1
    end
    
    hash.values.each { |v| answer *= v }
    
    return answer - 1
end