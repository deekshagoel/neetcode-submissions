class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList();
        int l=0, r=0, idx=0;
        int[] maximum = new int[n-k+1];

        while(r<n){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[r]){
                deque.removeLast();
            }

            deque.addLast(r);

            if(deque.getFirst()<l){
                deque.removeFirst();
            }
            if(r-l+1 == k){
                maximum[idx] = nums[deque.getFirst()];
                idx++;
                l++;
            }
            r++;
        }
        return maximum;
    }
}
