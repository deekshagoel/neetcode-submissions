class Solution {
    public int search(int[] nums, int target) {
        
        int l=0, r=nums.length-1;

        while(l<r){
            int mid=(r+l)/2;

            if(nums[mid] > nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }

        int pivot = l;


        r = nums.length-1;
        l=0;
        if(target >= nums[pivot] && target <= nums[r]){
            return bin(nums, target, pivot, r);
        }else{
            return bin(nums, target, l, pivot-1);
        }
    }

    int bin(int[] nums, int target, int l, int r){
        while(l<=r){
            int mid = (r+l)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(target > nums[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return -1;
    } 
}
