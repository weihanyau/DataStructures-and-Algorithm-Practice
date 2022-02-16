package LeetCode;

import java.util.*;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        Map<Integer, Integer> occurrence = new HashMap<>();
        for(int num : nums){
            if(occurrence.get(num) != null && occurrence.get(num) == 1){
                return true;
            } else{
                occurrence.put(num, 1);
            }
        }
        return false;
    }
}
