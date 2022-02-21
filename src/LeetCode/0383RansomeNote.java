package LeetCode;

class RansomeNote{
    //My solution
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] ransomCount = new int[26];
            int[] magazineCount = new int[26];
            char[] ransomChars = ransomNote.toCharArray();
            char[] magazineChars = magazine.toCharArray();
            for(int i = 0; i < ransomChars.length; i++){
                ransomCount[ransomChars[i] - 'a']++;
            }
            for(int i = 0; i < magazineChars.length; i++){
                magazineCount[magazineChars[i] - 'a']++;
            }
            for(int i = 0; i < 26; i++){
                if(ransomCount[i] != magazineCount[i]){
                    return false;
                }
            }
            return true;
        }

        //Cleaner Solution by deducting from one array
        public boolean canConstructCleaner(String ransomNote, String magazine) {
            int[] arr = new int[26];
            for (int i = 0; i < magazine.length(); i++) {
                arr[magazine.charAt(i) - 'a']++;
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
}
