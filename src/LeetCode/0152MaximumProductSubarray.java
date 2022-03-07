class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currNegativeProductLeft = 1;
        int currNegativeProductRight = 1;
        for(int i = 0; i < nums.length; i++){
            if(currNegativeProductLeft == 0){
                currNegativeProductLeft = 1;
            }
            if(currNegativeProductRight == 0){
                currNegativeProductRight = 1;
            }
            currNegativeProductLeft *= nums[i];
            currNegativeProductRight *= nums[nums.length - i - 1];
            maxSoFar = Math.max(maxSoFar, currNegativeProductLeft);
            maxSoFar = Math.max(maxSoFar, currNegativeProductRight);
        }
        
        return maxSoFar;
    }
}