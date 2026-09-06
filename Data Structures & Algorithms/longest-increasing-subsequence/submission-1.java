class Solution {
    int maxLength = Integer.MIN_VALUE;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new int[n][n+1];

        //Arrays.fill(dp, -1);
        return getLISUtil(nums, 0, -1);
    }


    int getLISUtil(int[] nums, int current, int prev){
        if(current==nums.length){
            return 0;
        }

        if(dp[current][prev+1] != 0){
            return dp[current][prev+1];
        }

        int include=0, skip=0;
        //take
        if(prev == -1 || nums[current] > nums[prev]){
            include = 1+getLISUtil(nums, current+1, current);
        }
        //skip
        skip = getLISUtil(nums,current+1, prev);

        dp[current][prev+1]=Math.max(include, skip);

        return dp[current][prev+1];
    }
}
