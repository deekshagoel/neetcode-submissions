class Solution {

    class Task{
        int remaining;
        int availableTime;

        Task(int a, int b){
            remaining = a;
            availableTime = b;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Integer> hp = new PriorityQueue(Collections.reverseOrder());

        HashMap<Character, Integer> hm = new HashMap();
        for(char c : tasks){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for(int entry : hm.values()){
            hp.offer(entry);
        }

        Queue<Task> queue = new LinkedList();

        int time=0;
        while(!hp.isEmpty() || !queue.isEmpty()){

            time++;

            while(!queue.isEmpty() && queue.peek().availableTime == time){
                Task front = queue.poll();
                hp.offer(front.remaining);
            }

            if(!hp.isEmpty()){
                int top = hp.poll();

                if(top > 1){
                    queue.offer(new Task(top-1, time + n + 1));
                }
            }
        }

        return time;


    }
}
