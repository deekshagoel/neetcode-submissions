class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList();
        List<Integer> subset = new ArrayList();
        dfs(nums, 0,subset, res);
        return res;
    }

    void dfs(int[] nums, int  idx, List<Integer> subset, List<List<Integer>> res){
        if(idx>=nums.length){
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[idx]);
        dfs(nums, idx+1, subset, res);

        while(idx<nums.length-1 && nums[idx] == nums[idx+1]){
            idx++;
        }
        idx++;

        subset.remove(subset.size()-1);
        dfs(nums, idx, subset, res);
    }
}
