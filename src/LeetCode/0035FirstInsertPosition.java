package LeetCode;

class FirstInsertPositions {
    public int searchInsert(int[] nums, int target) {
        int middle = (nums.length - 1)/2;
        int lowerBound = 0;
        int upperBound = nums.length;
        while(nums[middle] != target){
            if(lowerBound > upperBound){
                return nums[middle] > target ? middle : middle + 1 ;
            }
            if(nums[middle] < target){
                lowerBound = middle + 1;
            } else{
                upperBound = middle - 1;
            }
            middle = (lowerBound + upperBound) / 2;
        }
        return middle;
    }
}
