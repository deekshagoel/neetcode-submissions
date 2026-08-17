class Solution {

    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n];

        
      return Math.max(houseRob(nums, 0, n-2, dp1), houseRob(nums, 1, n-1, dp2));
    }


    int houseRob(int[] nums, int start, int end, int[] dp){
        int rob1 = 0, rob2 = 0;
        for(int i=start; i<=end; i++){
            int current = Math.max(nums[i] + rob2, rob1);
            rob2=rob1;
            rob1=current;
        }
        return rob1;
    }
}
