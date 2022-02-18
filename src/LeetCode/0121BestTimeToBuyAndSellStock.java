package LeetCode;

class BestTimeToBuyAndSellStock {
    //O(n) solution
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxNum = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            int profit = maxNum - prices[i];
            if(prices[i] > maxNum){
                maxNum = prices[i];
            } else if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    //Kadane's Algorithm
    public int maxProfitKadane(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
