class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n];

        
      return Math.max(houseRob(nums, 0, n-2, dp1), houseRob(nums, 1, n-1, dp2));
       // houseRob(nums, 0, n-2);
       // houseRob(nums, 1, n-1);
      
      //return maximum;
    }


    int houseRob(int[] nums, int start, int end, int[] dp){
        if(start > end){
            return 0;
        }

        if(dp[start]!=0){
            return dp[start];
        }

        int take = nums[start] + houseRob(nums, start+2, end, dp);
        int skip = houseRob(nums, start+1, end, dp);

        dp[start] = Math.max(take, skip);
        return dp[start];
    }
}
