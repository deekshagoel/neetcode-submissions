class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<int[]>[] adj = new ArrayList[n+1];
        
        for(int i=0; i<=n ;i++){
            adj[i] = new ArrayList();
        }
        
        for(int[] time : times){
            int src = time[0];
            int dest = time[1];
            int cost = time[2];

            adj[src].add(new int[]{dest, cost});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{k, 0});

        while(!queue.isEmpty()){
            int[] top = queue.poll();
            int node = top[0];
            int time = top[1];

            for(int[] nei : adj[node]){
                int neighbour = nei[0];
                int edge = nei[1];
                if(time + edge < dist[neighbour]){
                    dist[neighbour] = time + edge;
                    queue.add(new int[]{neighbour, dist[neighbour]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            //Syste
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            if(dist[i] > max){
                max = dist[i];
            }
        }
        return max;
    }
}
