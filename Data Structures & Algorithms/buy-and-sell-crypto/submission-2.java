class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int minBuy  = prices[0];
        int profit = 0;
        for(int i=1; i<n; i++){
            minBuy  = Math.min(prices[i], minBuy);
            profit = Math.max(profit, prices[i]-minBuy);
        }
        return profit;
    }
}
