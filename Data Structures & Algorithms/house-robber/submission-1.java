class Solution {

    int[] dp;
  
    public int rob(int[] nums) {
        dp = new int[nums.length];
        return Math.max(maxAmount(nums, 0), maxAmount(nums, 1));
    }

    int maxAmount(int[] nums, int idx){
        if(idx>=nums.length){
            return 0;
        }

        if(dp[idx] != 0){
            return dp[idx];
        }
        
        int take = nums[idx] + maxAmount(nums, idx+2);
        int skip = maxAmount(nums, idx+1);
        dp[idx] = Math.max(take, skip);
        return dp[idx];
} 
}

