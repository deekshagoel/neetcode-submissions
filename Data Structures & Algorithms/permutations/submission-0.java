class Solution {
    List<List<Integer>> result;
    int[] pick;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList();
        pick = new int[nums.length];
        permuteUtil(nums, 0, new ArrayList());
        return result;
    }

    void permuteUtil(int[] nums, int index, List<Integer> current){
        if(current.size()==nums.length){
            System.out.println(current.size());
            current.stream().forEach(i -> System.out.println("helll" + i));
            result.add(new ArrayList(current));
        }

        for(int i = 0; i< nums.length; i++){
            if(pick[i] == 0){
            pick[i] = 1;
            current.add(nums[i]);
            System.out.println("inner " +current.size());

            permuteUtil(nums, i, current);
            pick[i] = 0;
            current.remove(current.size()-1);
            }
        }
    }
}
