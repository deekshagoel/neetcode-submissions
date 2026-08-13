class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet();
        for(int n : nums){
            set.add(n);
        }

        int i=0, n= nums.length;
        int max = 0;

        while(i<n){
            int curr = nums[i];
            int length=0;
            while(set.contains(curr)){
                length++;
                curr++;
            }
            max = Math.max(max, length);
            i++;
        }
        return max;
    }
}
