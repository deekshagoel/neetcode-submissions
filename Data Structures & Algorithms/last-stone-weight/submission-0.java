class Solution {
    
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue();

        for(int n : stones){
            queue.offer(-1 * n);
        }

        while(queue.size() > 1 ){
            int a = queue.poll();
            int b = queue.poll();

            queue.offer((a-b));
        }

        return -1 * queue.poll();
    }
}
