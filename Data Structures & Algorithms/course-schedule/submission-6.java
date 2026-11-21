class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
            indegree[u]++; 
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int canFinish = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            canFinish++;
            for(int c : adj.get(course)){
                indegree[c]--;
                if(indegree[c]==0){
                queue.add(c);
            }
            }
            
        }

        return canFinish==numCourses;
    }
}
