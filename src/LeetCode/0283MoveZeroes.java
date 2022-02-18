package LeetCode;

class MoveZeroes {
    //O(n^2) solution
    public void moveZeroes(int[] nums) {
        int zeroPtr = 0;
        while(zeroPtr < nums.length - 1){
            int nonZeroPtr = zeroPtr + 1;
            while(nonZeroPtr < nums.length){
                if(nums[zeroPtr] != 0){
                    break;
                }
                if(nums[nonZeroPtr] == 0){
                    nonZeroPtr++;
                    continue;
                }
                int temp = nums[zeroPtr];
                nums[zeroPtr] = nums[nonZeroPtr];
                nums[nonZeroPtr] = temp;
                break;
            }
            zeroPtr++;
        }
    }

    //O(n) Solution
    public void moveZeroesEfficient(int[] nums) {
        int setter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[setter++] = nums[i];
            }
        }
        while(setter < nums.length){
            nums[setter++] = 0;
        }
    }
}
