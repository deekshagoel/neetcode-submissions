class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList();
        List<Integer> subset = new ArrayList();
        rec(candidates, 0, target, subset, res);
        return res;
    }

    void rec(int[] nums, int idx, int target, List<Integer> subset, List<List<Integer>> res)
    {
        if(target == 0){
            res.add(new ArrayList(subset));
            return;
        }

        if(target<0 || idx>=nums.length){
        return;
        }
        
        subset.add(nums[idx]);
        rec(nums, idx+1, target-nums[idx], subset, res);
        subset.remove(subset.size()-1);

        while(idx<nums.length-1 && nums[idx] == nums[idx+1]){
            idx++;
        }
        idx++;

        rec(nums, idx, target, subset, res);
    }
}