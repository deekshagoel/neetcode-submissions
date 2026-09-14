class Solution {
    int[][] dp;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        for(int i=0;i<nums.length; i++){
            sum += nums[i];
        }
        dp = new int[nums.length][2*sum+1];
        return ways(nums, 0, 0, target);
    }

    int ways(int[] nums, int index, int current, int target){
        if(current == target && index >= nums.length){
            return 1;
        }
        if(index>=nums.length){
            return 0;
        }

        if(dp[index][sum + current] != 0){
            return dp[index][sum + current];
        }

        dp[index][sum + current] = ways(nums, index+1,  current + nums[index], target) + 
        ways(nums, index+1, current - nums[index], target);

        return dp[index][sum + current];
    }
}
