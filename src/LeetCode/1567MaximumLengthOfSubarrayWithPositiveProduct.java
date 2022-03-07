class Solution {
    public int getMaxLen(int[] nums) {
        int currProductLeft = 1;
        int currProductRight = 1;
        int leftCount = 0;
        int rightCount = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(currProductLeft == 0){
                currProductLeft = 1;
                leftCount = 0;
            }
            if(currProductRight == 0){
                currProductRight = 1;
                rightCount = 0;
            }
            currProductLeft *= nums[i];
            currProductRight *= nums[nums.length - i - 1];
            leftCount++;
            rightCount++;
            if(currProductLeft > 0){
                maxCount = Math.max(maxCount, leftCount);
                currProductLeft = 1;
            } else if(currProductLeft < 0){
                currProductLeft = -1;
            }
            
            if(currProductRight > 0){
                maxCount = Math.max(maxCount, rightCount);
                currProductRight = 1;
            } else if(currProductRight < 0){
                currProductRight = -1;
            }
        }
        return maxCount;
    }
}