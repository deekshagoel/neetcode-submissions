class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int n = nums.length;
        int curMax = 1, curMin = 1;

        for(int i=0;i<n;i++){
            int curMax_prev = curMax;

            curMax =  Math.max(nums[i], Math.max(nums[i] * curMax, nums[i] * curMin));

            curMin =  Math.min(nums[i], Math.min(nums[i] * curMax_prev, nums[i] * curMin));

            maxProd = Math.max(maxProd, curMax);
        }

        return maxProd;
    }
}
