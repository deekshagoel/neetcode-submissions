class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer> res=new ArrayList();

        List<List<Integer>> adj = new ArrayList();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses; i++){
            adj.add(new ArrayList());
        }

        for(int[] i : prerequisites){
            adj.get(i[1]).add(i[0]);
            indegree[i[0]]++;
        }

        Queue<Integer> queue = new LinkedList();

         for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int finish = 0;
        while(!queue.isEmpty()){

            int course = queue.poll();
            finish++;
            res.add(course);

            for(int i:adj.get(course)){
                indegree[i]--;

                if(indegree[i] == 0){
                    queue.add(i);
                }
            }    
        }
        int[] output = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }
        return finish == numCourses ? output : new int[0];
    }
}
