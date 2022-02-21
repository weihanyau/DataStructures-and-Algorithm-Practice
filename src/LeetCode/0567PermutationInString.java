package LeetCode;

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        if(s1Chars.length > s2Chars.length){
            return false;
        }
        int[] bucket1 = new int[26];
        int[] bucket2 = new int[26];

        for(int i = 0; i < s1Chars.length; i++){
            bucket1[s1Chars[i] - 'a']++;
        }

        int j = 0;
        int k = 0;
        while(k < s2Chars.length){
            bucket2[s2Chars[k] - 'a']++;

            if(k - j + 1 == s1Chars.length && allEquals(bucket1, bucket2)){
                return true;
            } else if(k - j + 1 < s1Chars.length){
                k++;
            } else{
                bucket2[s2Chars[j] - 'a']--;
                k++;
                j++;
            }
        }
        return false;
    }

    public boolean allEquals(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
