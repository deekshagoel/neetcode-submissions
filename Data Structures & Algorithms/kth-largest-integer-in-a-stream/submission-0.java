class KthLargest {
    PriorityQueue<Integer> hp = new PriorityQueue();
    int K;
    public KthLargest(int k, int[] nums) {
        this.K = k;
        for(int n : nums){
            hp.offer(n);
            if(hp.size()>k){
                hp.poll();
            }
        }
    }
    
    public int add(int val) {
        hp.offer(val);
        while(hp.size() > K){
            hp.poll();
        }
        return hp.peek();
    }
}
