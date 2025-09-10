# @param {Integer[]} nums
# @return {Integer}
def maximize_greatness(nums)
    i = 0
    j = 0
    answer = 0
    nums.sort!

    while (j < nums.size)
        if (nums[i] < nums[j])
            answer += 1
            i += 1
        end
        j += 1
    end

    answer
end