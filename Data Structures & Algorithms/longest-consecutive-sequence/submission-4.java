class Solution {
    public int longestConsecutive(int[] nums) {
        
        int n = nums.length;

        HashSet<Integer> hs = new HashSet();
        int max=0, count =0;

        for(int i:nums){
            hs.add(i);
        }

        for(int i:nums){
            if(!hs.contains(i-1)){
                System.out.println(i);
                count = 1;
        //HashSet<Integer> res = new HashSet();

             //   res.add(i);
                while(hs.contains(i+1)){
                                    System.out.println(i);

                    count++;
                    i=i+1;
                   // res.add(i+1);
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
