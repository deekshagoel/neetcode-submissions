class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int leftMax = prices[0];
        int profit = 0;
        for(int i=1; i<n; i++){
            leftMax = Math.min(prices[i], leftMax);
            profit = Math.max(profit, prices[i]-leftMax);
        }
        return profit;
    }
}
