package LeetCode;

class TwoSum2 {
    //O(N log N) Solution
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i = 1; i < numbers.length; i++){
            int found = binarySearch(numbers, i - 1, target - numbers[i]);
            if(found != -1){
                result[0] = found + 1;
                result[1] = i + 1;
                return result;
            }
        }
        return result;
    }
    public int binarySearch(int[] nums, int end, int target){
        int start = 0;
        while(start <= end){
            int mid = (end + start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }

    //O(n) Solution
    public int[] twoSumEfficient(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }
}
