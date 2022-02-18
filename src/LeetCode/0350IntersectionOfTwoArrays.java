package LeetCode;
import java.util.*;

class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> table = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i : nums1){
            if(!table.containsKey(i)){
                table.put(i, 1);
            } else{
                table.put(i, table.get(i) + 1);
            }
        }
        for(int i : nums2){
            if(table.containsKey(i) && table.get(i) > 0){
                result.add(i);
                table.put(i, table.get(i) - 1);
            }
        }
        int[] ans = new int[result.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
}
