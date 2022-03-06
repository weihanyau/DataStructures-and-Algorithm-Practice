class Solution {
    public int jump(int[] nums) {
        int minJump = 0;
        int currJumps = nums[0];
        int currIndex = 0;
        int dp = 1;
        for(int i = 1; i < nums.length; i++){
            if(i >= dp){
                dp = currIndex + currJumps + 1;
                minJump++;
            }
            if(currIndex + currJumps < i + nums[i]){
                currIndex = i;
                currJumps = nums[i];
            }
        }
        return minJump;
    }
}