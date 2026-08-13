class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList();

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] i : prerequisites){
            indegree[i[0]]++;
            adj.get(i[1]).add(i[0]);
        }

        Queue<Integer> q = new LinkedList();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()){
            int n = q.poll();

            finish++;

            for(int i : adj.get(n)){
                
                indegree[i]--;

                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }

        return finish == numCourses;
    }
}
