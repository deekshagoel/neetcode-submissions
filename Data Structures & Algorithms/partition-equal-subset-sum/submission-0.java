class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        return canPartitionUtil(nums, 0, 0, sum);
    }

    boolean canPartitionUtil(int[] nums, int index, int currentSum, int targetSum){
        if(2 * currentSum == targetSum){
            return true;
        }
        if(index>=nums.length){
            return false;
        }

        return canPartitionUtil(nums, index+1, nums[index] + currentSum, targetSum) 
        || canPartitionUtil(nums, index+1, currentSum, targetSum);

    }
}
