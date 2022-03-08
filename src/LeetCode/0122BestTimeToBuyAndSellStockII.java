class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prevStock = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prevStock > 0){
                profit += prices[i] - prevStock;
            }
            prevStock = prices[i];
        }
        return profit;
    }
}