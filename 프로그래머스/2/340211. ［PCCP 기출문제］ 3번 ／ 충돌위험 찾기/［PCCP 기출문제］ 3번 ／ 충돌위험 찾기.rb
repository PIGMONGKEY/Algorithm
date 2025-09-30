def solution(points, routes)
    answer = 0
    @hash = { }
    
    routes.each_with_index do |route, index|
        find_route 0, [points[route[0]-1][0], points[route[0]-1][1]], points, route, 1
    end
    
    @hash.keys.each do |time|
        map = @hash[time]
        uniq_map = map.uniq
        
        next if map.size == uniq_map.size
        
        answer += map.tally.count { |_, count| count > 1 }
    end
    
    return answer
end

private

def find_route(time, cur, points, routes, i)
    r = cur[0]
    c = cur[1]
    
    if i >= routes.size
        if @hash.has_key? time
            @hash[time] << [r, c]
        else
            @hash[time] = ([] << [r, c])
        end
        return
    end
    
    next_dest = [points[routes[i]-1][0], points[routes[i]-1][1]]
    
    calculate_value = r > next_dest[0] ? -1 : 1
    
    while r != next_dest[0]
        if @hash.has_key? time
            @hash[time] << [r, c]
        else
            @hash[time] = ([] << [r, c])
        end
        r += calculate_value
        time += 1
    end
    
    calculate_value = c > next_dest[1] ? -1 : 1
    
    while c != next_dest[1]
        if @hash.has_key? time
            @hash[time] << [r, c]
        else
            @hash[time] = ([] << [r, c])
        end
        c += calculate_value
        time+=1
    end
    
    find_route time, [r, c], points, routes, i + 1
end
