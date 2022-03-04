class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        int first = 0;
        int second = buckets[0];
        for(int i = 0; i < nums.length; i++){
            buckets[nums[i]] += nums[i];
        }
        for(int i = 1; i < buckets.length; i++){
            int temp = Math.max(first + buckets[i], second);
            first = second;
            second = temp;
        }
        return second;
    }
}