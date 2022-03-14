class Solution {
	//Brute Force + Memoization
    private Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length][amount + 1];
        return count(amount, coins, 0);
    }
    public int count(int amount, int[] coins, int index){
        if(amount == 0){
            return 1;
        }
        if(index >= coins.length || amount < 0){
            return 0;
        }
        if(dp[index][amount] != null){
            return dp[index][amount];
        }
        dp[index][amount] = count(amount - coins[index], coins, index) + count(amount, coins, index + 1);
        return dp[index][amount];
    }
}