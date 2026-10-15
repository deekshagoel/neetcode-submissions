class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adj = new ArrayList[n];

        for(int i=0; i<n ;i++){
            adj[i] = new ArrayList();
        }

        for(int[] flight : flights){
            int s = flight[0];
            int d = flight[1];
            int dist = flight[2];

            adj[s].add(new int[]{d, dist});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0, src, dist[src]});

        while(!queue.isEmpty()){
            int[] path = queue.poll();

            int stop = path[0];
            int node = path[1];
            int weight = path[2];

            if(stop>k+1) break;

            for(int[] nei : adj[node]){
                int adjNode = nei[0];
                int edgeW = nei[1];

                if(weight + edgeW < dist[adjNode] && stop<=k){
                    queue.add(new int[]{stop+1, adjNode, weight + edgeW});
                    dist[adjNode] = weight + edgeW;
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        
    }
}
