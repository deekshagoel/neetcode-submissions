class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        }

        int[] visited = new int[n];
        int[] indegree = new int[n];

        for(int[] edge : edges){
            int v = edge[1];
            int u = edge[0];
            indegree[v]++;
            indegree[u]++;
            adj.get(v).add(u);
            adj.get(u).add(v);
        }

        Queue<int[]> queue = new LinkedList();
        
            queue.add(new int[]{0,-1});
        
        int visitedNodes = 0;
        while(!queue.isEmpty()){
            int[] childParent = queue.poll();
            int node = childParent[0];
            int parent = childParent[1];
            visitedNodes++;
            for(int nei : adj.get(node)){
                if(nei==parent){
                    continue;
                }
                if(visited[nei] == 1){
                    return false;
                }
                visited[nei] = 1;
                queue.add(new int[]{nei, node});
            }
        }


        return n==visitedNodes;
    }
}
