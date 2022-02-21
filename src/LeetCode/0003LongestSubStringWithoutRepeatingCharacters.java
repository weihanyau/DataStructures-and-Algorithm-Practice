package LeetCode;
import java.util.*;

class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;
        int i = 0;
        int repeatIndex = -1;
        while(i < chars.length){
            if(!map.containsKey(chars[i]) || (map.containsKey(chars[i]) && map.get(chars[i]) <= repeatIndex)){
                map.put(chars[i], i);
                count++;
                max = Math.max(max, count);
                i++;
            }else{
                repeatIndex = map.get(chars[i]);
                count = i - map.get(chars[i]) - 1;
            }
        }
        return max;
    }

    //Less Efficient early concept
    public int lengthOfLongestSubstringSlower(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;
        int i = 0;
        while(i < chars.length){
            if(!map.containsKey(chars[i])){
                map.put(chars[i], i);
                count++;
                max = Math.max(max, count);
                i++;
            }else{
                count = 0;
                i = map.get(chars[i]) + 1;
                map.clear();
            }
        }
        return max;
    }
}
