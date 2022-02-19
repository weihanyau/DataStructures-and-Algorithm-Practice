package LeetCode;

class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' ' || i == chars.length - 1){
                int end = chars[i] == ' ' ? i - 1 : i;
                reverseString(chars, start, end);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    public void reverseString(char[] s, int start, int end) {
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
