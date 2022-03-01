package LeetCode;

class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1){
                ans += 1;
            }
            n >>>= 1;
            if(i != 31){
                ans = ans << 1;
            }
        }
        return ans;
    }
}
