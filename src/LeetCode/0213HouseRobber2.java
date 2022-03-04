class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        int rob1 = second;
        
        first = 0;
        second = nums[nums.length - 1];
        for(int i = nums.length - 2; i > 0; i--){
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        int rob2 = second;
        return Math.max(rob1, rob2);
    }
}