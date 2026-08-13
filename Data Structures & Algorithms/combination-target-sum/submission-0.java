class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList();
        List<Integer> subset = new ArrayList();
        rec(nums, 0, target, subset, res);
        return res;
    }

    void rec(int[] nums, int idx, int target, List<Integer> subset, List<List<Integer>> res)
    {
        if(target == 0){
            res.add(new ArrayList(subset));
            return;
        }

if (target < 0 || idx == nums.length) {
    return;
}
        subset.add(nums[idx]);
        rec(nums, idx, target-nums[idx], subset, res);
        subset.remove(subset.size()-1);
        rec(nums, idx+1, target, subset, res);
    }
}
