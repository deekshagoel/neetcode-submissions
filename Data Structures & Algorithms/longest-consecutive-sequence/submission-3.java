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
            
            if(!set.contains(curr-1)){
               int length=1;
                while(set.contains(curr+1))
                {
                    length++;
                    curr++;
                }
                max = Math.max(max, length);
            }
            
            i++;
        }
        return max;
    }
}
