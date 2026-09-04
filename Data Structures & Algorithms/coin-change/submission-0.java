class Solution {
    int max = 100000;
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int m = ways(coins, 0, amount);
        return  m==  max? -1 : m;
    }

    int ways(int[] coins, int index, int amount){
        if(amount == 0){
            return 0;
        }

        if(index >= coins.length || amount<0){
            return max;
        }

        int take = 1 + ways(coins, index, amount-coins[index]);
        int skip = ways(coins, index+1, amount);
        int min = Math.min(take, skip);
        return min;
    }
}
