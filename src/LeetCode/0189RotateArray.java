package LeetCode;

class RotateArray {
    public void rotate(int[] nums, int k) {
        int step = k % nums.length;
        if(nums.length <= 1 || step == 0){
            return;
        }
        int[] tmp = new int[step];
        for(int i = 0; i < step; i++){
            tmp[i] = nums[nums.length - step + i];
        }
        for(int i = nums.length - step - 1; i >= 0; i--){
            nums[i + step] = nums[i];
        }
        for(int i = 0; i < step; i++){
            nums[i] = tmp[i];
        }
    }

    //O(1) solution, wtf
    public void rotateWithReverse(int[] nums, int k) {
        k = k % nums.length;
        if(nums.length <= 1 || k == 0){
            return;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
