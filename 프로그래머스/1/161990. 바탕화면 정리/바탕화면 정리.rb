def solution(wallpaper)
    answer = []
    ypos = []
    xpos = []

    wallpaper.each.with_index do |line, y|
        line.each_char.with_index do |cell, x|
            if (cell == "#")
                xpos << x
                ypos << y
            end
        end
    end
    
    answer = [ ypos.min, xpos.min, ypos.max+1, xpos.max+1 ]
    
    return answer
end