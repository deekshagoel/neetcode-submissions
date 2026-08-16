class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
       dp = new int[cost.length];
       return Math.min(minCost(cost, 0), minCost(cost, 1));
    }

    int minCost(int[] cost, int idx){
        if(idx>=cost.length){
            return 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        dp[idx] = cost[idx] + Math.min(minCost(cost, idx+1),
        minCost(cost, idx+2));
        return dp[idx];
    }


}
