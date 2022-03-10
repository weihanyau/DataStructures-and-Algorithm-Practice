class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];
        buy[0] = 0;
        sell[0] = -prices[0];
        cooldown[0] = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] - prices[i]);
            cooldown[i] = sell[i - 1] + prices[i];
        }
        return Math.max(buy[n - 1], cooldown[n - 1]);
    }
}