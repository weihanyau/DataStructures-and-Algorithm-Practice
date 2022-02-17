package LeetCode;

class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int positive = nums.length - 1;
        int negative = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            int left = nums[negative] < 0 ? nums[negative] * nums[negative] : -1;
            int right = nums[positive] >= 0 ? nums[positive] * nums[positive] : -1;
            if(left > right){
                ans[i] = left;
                negative++;
            } else{
                ans[i] = right;
                positive--;
            }
        }
        return ans;
    }
}
