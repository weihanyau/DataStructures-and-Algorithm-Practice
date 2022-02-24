package LeetCode;
import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c == '('){
                bracket.push('(');
            }
            if(c == '{'){
                bracket.push('{');
            }
            if(c == '['){
                bracket.push('[');
            }
            if(c == ')'){
                if(bracket.empty() || bracket.peek() != '(') return false;
                bracket.pop();
            }
            if(c == '}'){
                if(bracket.empty() || bracket.peek() != '{') return false;
                bracket.pop();
            }
            if(c == ']'){
                if(bracket.empty() || bracket.peek() != '[') return false;
                bracket.pop();
            }
        }
        if(!bracket.empty()){
            return false;
        }
        return true;
    }
}
