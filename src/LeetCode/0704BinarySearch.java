package LeetCode;

class BinarySearch {
    public int search(int[] nums, int target) {
        int middle = (nums.length - 1)/2;
        int lowerBound = -1;
        int upperBound = -1;
        while(nums[middle] != target){
            if(lowerBound > upperBound){
                return -1;
            }
            if(nums[middle] < target){
                lowerBound = middle + 1;
                upperBound = upperBound == -1 ? nums.length - 1 : upperBound;
            } else{
                upperBound = middle - 1;
                lowerBound = lowerBound == -1 ? 0 : lowerBound;
            }
            middle = (lowerBound + upperBound) / 2;
        }
        return middle;
    }
}
