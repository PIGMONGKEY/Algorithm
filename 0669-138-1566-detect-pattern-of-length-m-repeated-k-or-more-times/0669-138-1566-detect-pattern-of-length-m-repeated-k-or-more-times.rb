# @param {Integer[]} arr
# @param {Integer} m
# @param {Integer} k
# @return {Boolean}
def contains_pattern(arr, m, k)
    for i in 0..arr.size - m
        sarr = arr[i, m]
        start_num = i + m
        count = 1
        while start_num <= arr.size - m
            break unless sarr.eql? arr[start_num, m]
            count += 1
            start_num += m
            return true if count >= k
        end
    end

    return false
end