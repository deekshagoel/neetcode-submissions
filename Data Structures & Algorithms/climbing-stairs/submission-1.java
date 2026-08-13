class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        return countWays(n);
    }

    int countWays(int n){
        if(n==1){
            dp[1] = 1;
        }
        if(n==2){
            dp[2] = 2;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = countWays(n-1) + countWays(n-2);
        return dp[n];
    }
}
