# n개의 퍼즐 푸렁야 함
# 난이도, 소요 시간 있음
# 난이도가 더 쉬우면 안틀리고 cur 소요
# 더 어려우면 레벨차이만큼 틀림
# 틀리면 cur  + prev 소요
# 이후 cur 소요 후 해결
# limit 제한시간
# 모두 해결 가능한 숙련도 최솟값

def solution(diffs, times, limit)
    left = 1
    right = diffs.max
    center = (left + right) / 2
    lastSuccessLevel = right
    
    while true
        prevCenter = center
        center = (left + right) / 2
        
        break if center > right || center < left
        
        if solve? center, diffs, times, limit
            right = center - 1
            lastSuccessLevel = center
        else
            left = center + 1
        end
    end
    
    return lastSuccessLevel
end

private

def solve?(level, diffs, times, limit)
    usedTime = 0;
    prevTime = 0;
    diffs.each_with_index do |diff, index|
        usedTime += (diff - level) * (prevTime + times[index]) if level < diff
        usedTime += times[index]
        prevTime = times[index]

        return false if usedTime > limit
    end
    
    return true
end