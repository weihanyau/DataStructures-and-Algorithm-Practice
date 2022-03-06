class Solution {
    public boolean canJump(int[] nums) {
        int jumpsLeft = nums[0];
        if(jumpsLeft == 0 && nums.length > 1) return false;
        for(int i = 1; i < nums.length - 1; i++){
            jumpsLeft--;
            if(jumpsLeft < nums[i]){
                jumpsLeft = nums[i];
            }
            if(jumpsLeft == 0){
                return false;
            }
        }
        return true;
    }
}