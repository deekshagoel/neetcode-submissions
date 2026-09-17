class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList();
        int count = 0;

        for(int i=0; i<n; i++){
            if(visited[i] == false){
                visited[i] = true;
                queue.add(i);
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(int nei:adj.get(node)){
                        if(visited[nei] == false){
                            visited[nei] = true;
                            queue.add(nei);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
