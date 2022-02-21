package LeetCode;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length != tChars.length){
            return false;
        }
        for(int i = 0; i < sChars.length; i++){
            sCount[sChars[i] - 'a']++;
        }
        for(int i = 0; i < tChars.length; i++){
            tCount[tChars[i] - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(sCount[i] != tCount[i]){
                return false;
            }
        }
        return true;
    }

    //Cleaner solution by using 1 bucket
    public boolean isAnagramCleaner(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
