package LeetCode;

class BinarySearch {
    public int search(int[] nums, int target) {
        int middle = (nums.length - 1)/2;
        int lowerBound = 0;
        int upperBound = nums.length - 1;
        while(nums[middle] != target){
            if(lowerBound > upperBound){
                return -1;
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
