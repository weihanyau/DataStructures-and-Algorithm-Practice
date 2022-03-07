class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //Kadane's Algorithm
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        int currSumMin = 0;
        int arraySum = 0;
        if(nums.length == 1){
            return nums[0];
        }
        
        for(int i = 0; i < nums.length; i++){
            arraySum += nums[i];
            currSum += nums[i];
            currSumMin += nums[i];
            
            min = Math.min(min, currSumMin);
            max = Math.max(max, currSum);
    
            if(currSum < 0){
                currSum = 0;
            }
            if(currSumMin > 0){
                currSumMin = 0;
            }
        }
        if(arraySum == min){
            return max;
        }
        return Math.max(max, arraySum - min);
    }
}