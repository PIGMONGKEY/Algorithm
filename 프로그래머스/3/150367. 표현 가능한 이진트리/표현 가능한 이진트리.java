class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        String binary;
        
        for (int i=0; i<numbers.length; i++) {
            int center;
            String tempBinary;
            binary = Long.toBinaryString(numbers[i]);
            tempBinary = new String(binary);

            if (binary.length() % 2 == 0)
                tempBinary = "0" + tempBinary;
            
            center = tempBinary.length() / 2;
            
            for (int j=center; j>=0; j--) {
                if (!checkBinaryLength(tempBinary.length())) {
                    tempBinary = "00" + tempBinary;
                    continue;
                }

                if (checkFullBinaryTree(0, tempBinary.length() - 1, tempBinary) != -1) {
                    answer[i] = 1;
                    break;
                }
                
                tempBinary = "00" + tempBinary;
            }
        }
        
        return answer;
    }
    
    private boolean checkBinaryLength(int length) {
        int i=1, j=1;
        while (i <= length) {
            if (i == length)
                return true;
            
            i += Math.pow((double) 2, (double) j++);
        }
        
        return false;
    }
    
    private int checkFullBinaryTree(int left, int right, String binary) {
        int center, leftValue, rightValue, centerValue;
        center = (left + right) / 2;
        
        if (center <= left || center >= right)
            return binary.charAt(center) - '0';

        leftValue = checkFullBinaryTree(left, center - 1, binary);
        rightValue = checkFullBinaryTree(center + 1, right, binary);
        centerValue = binary.charAt(center) - '0';
        
        if (leftValue == -1 || rightValue == -1)
            return -1;
        
        if (centerValue == 0 && (leftValue + rightValue > 0))
            return -1;

        return centerValue;
    }
}