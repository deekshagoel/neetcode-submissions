class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue(2);
        for(int num : nums){
            minHeap.offer(-1 * num);
        }

        while(k-1 > 0){
            
            int  p = minHeap.poll();
            System.out.println(p);
            k--;
        }

        return -1 * minHeap.peek(); 
    }
}
