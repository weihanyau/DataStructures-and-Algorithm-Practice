package LeetCode;
import java.util.*;

class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!map.containsKey(chars[i])){
                map.put(chars[i], 1);
                continue;
            }
            map.put(chars[i], map.get(chars[i]) + 1);
        }
        for(int i = 0; i < chars.length; i++){
            if(map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
