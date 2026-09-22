class Solution {
    public int singleNumber(int[] nums) {

        int miss=0;
        for(int i=0;i<nums.length;i++){
            miss = miss ^ nums[i];
        }
        return miss;
    }
}
