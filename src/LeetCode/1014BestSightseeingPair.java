class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prevMax = 0;
        int maxScore = 0;
        for(int i = 0; i < values.length; i++){
            maxScore = Math.max(maxScore, prevMax + values[i] - i);
            
            if(prevMax < values[i] + i){
                prevMax = values[i] + i;
            }
        }
        return maxScore;
    }
}