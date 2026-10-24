class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        List<List<Integer>> adj = new ArrayList();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList());
        }
        int[] indeg = new int[numCourses];
        for(int[] pre:prerequisites){
            int u = pre[1];
            int v = pre[0];

            adj.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                queue.add(i);
            }
        }

        int finish = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();

            for(Integer child:adj.get(course)){
                indeg[child]--;
            
            if(indeg[child] == 0){
                queue.add(child);
            }
            }

            finish++;
        }

        return finish == numCourses ? true : false;

    }
}
