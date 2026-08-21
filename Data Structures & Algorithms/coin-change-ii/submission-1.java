class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];
        
        return ways(coins, 0, amount);
    }

    int ways(int[] coins, int index, int amount){

        if(amount==0){
            return 1;
        }
        if(index >= coins.length || amount < 0){
            return 0;
        }

        if( dp[index][amount] !=0 ){
            return  dp[index][amount];
        }

        dp[index][amount] = ways(coins, index, amount - coins[index]) + 
                ways(coins, index+1, amount);
        return  dp[index][amount];
    }
}
