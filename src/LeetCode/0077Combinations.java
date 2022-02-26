package LeetCode;
import java.util.*;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            nums[i - 1] = i;
        }
        recurse(0, nums, k, new ArrayList<Integer>() , ans);
        return ans;
    }

    public void recurse(int curr, int[] nums, int k, List<Integer> c, List<List<Integer>> ans){
        if(c.size() == k){
            ans.add(new ArrayList<>(c));
        } else {
            for(int i = curr; i < nums.length; i++){
                c.add(nums[i]);
                recurse(i + 1, nums, k, c, ans);
                c.remove(c.size() - 1);
            }
        }
    }
}
