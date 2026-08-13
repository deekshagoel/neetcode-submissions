class Solution {
    public int missingNumber(int[] nums) {
        
        boolean isZeroPresent=false;
        int  n=nums.length;
        int sum = n*(n+1)/2;

        for(int i:nums){

            if(i==0){
                isZeroPresent=true;
            }

            sum -= i;
        }
        return isZeroPresent ? sum : 0;
    }
}
