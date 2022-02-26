package LeetCode;
import java.util.*;

class LetterCasePermutations {
    public List<String> letterCasePermutation(String s) {
        List<Integer> index = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        char[] chars =  s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                index.add(i);
            }
        }
        changeCase(ans, index, chars, 0);
        return ans;
    }
    public void changeCase(List<String> ans, List<Integer> index, char[] chars, int curr){
        if(curr >= index.size()){
            ans.add(new String(chars));
        } else{
            chars[index.get(curr)] = Character.toLowerCase(chars[index.get(curr)]);
            changeCase(ans, index, chars, curr + 1);
            chars[index.get(curr)] = Character.toUpperCase(chars[index.get(curr)]);
            changeCase(ans, index, chars, curr + 1);
        }
    }
}
