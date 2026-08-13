class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        return getMax(prices, 0, 1, dp); 
       // return dp[prices.length-1][1];
    }

    int getMax(int[] prices, int i, int canBuy, int[][] dp){
        if(i>=prices.length){
            return 0;
        }

        if(dp[i][canBuy] != 0){
            return dp[i][canBuy];
        }

        if(canBuy == 1){
            int buy = -prices[i] + getMax(prices, i+1, 0, dp);
            int skip = getMax(prices, i+1, 1, dp);
            dp[i][canBuy] = Math.max(buy, skip);
        }
        else{
            int sell = prices[i] + getMax(prices, i+2, 1, dp);
            int skip = getMax(prices, i+1, 0, dp);
            dp[i][canBuy] = Math.max(sell, skip);
        }
        return dp[i][canBuy];
    }
}
