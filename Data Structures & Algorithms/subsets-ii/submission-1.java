class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList();
      List<Integer> subset = new ArrayList();

      subsetUtil(nums, 0, subset, res);
      return res;  
    }

    void subsetUtil(int[] nums, int index, List<Integer> subset, List<List<Integer>> result){

        if(index==nums.length){
            result.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[index]);
        subsetUtil(nums, index+1, subset, result);

        while(index<nums.length-1 && nums[index] == nums[index+1]){
            index++;
        }

        subset.remove(subset.size()-1);
        subsetUtil(nums, index+1, subset, result);
    }
}
