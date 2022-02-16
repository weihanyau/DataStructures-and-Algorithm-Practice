package LeetCode;

class FirstBadVersion {
    public int firstBadVersion(int n) {
        int lowerBound = 1;
        int upperBound = n;
        int ans = -1;
        while(lowerBound <= upperBound){
            int middle = lowerBound + (upperBound - lowerBound) / 2;
            if(!isBadVersion(middle)){
                lowerBound = middle + 1;
            } else{
                ans = middle;
                upperBound = middle - 1;
            }
        }
        return ans;
    }

    //Placeholder
    public boolean isBadVersion(int n){
        return true;
    }
}
