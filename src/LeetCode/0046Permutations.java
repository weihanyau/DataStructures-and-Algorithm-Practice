package LeetCode;
import java.util.*;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Integer[] numsList = new Integer[nums.length];
        int i = 0;
        for (int value : nums){
            numsList[i++] = Integer.valueOf(value);
        }
        permute(ans, numsList, 0);
        return ans;
    }

    public void permute(List<List<Integer>> ans, Integer[] nums, int curr){
        if(curr >= nums.length){
            ans.add(new ArrayList<>(Arrays.asList(nums)));
        } else{
            for(int i = curr; i < nums.length; i++){
                int temp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = temp;
                permute(ans, nums, curr + 1);
                temp = nums[curr];
                nums[curr] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
