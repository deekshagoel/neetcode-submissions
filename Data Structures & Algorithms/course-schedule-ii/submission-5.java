class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //List<List<Integer>> pre = new ArrayList();
        HashMap<Integer, List<Integer>> pre = new HashMap();
        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites){
            if(pre.containsKey(p[1])){
                pre.get(p[1]).add(p[0]);
            }else{
                List<Integer> dep = new ArrayList();
                dep.add(p[0]);
                pre.put(p[1], dep);
            }

            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
              //  System.out.println( "indegree " + i);
            }
        }

        if(queue.isEmpty()){
            return new int[0];
        }

        int[] seq = new int[numCourses];
        int i=0;
        while(!queue.isEmpty()){
            int course = queue.poll();

            seq[i++] = course;
           // System.out.println("seq " + course);

            if(pre.containsKey(course)){
                for(int c:pre.get(course)){
                  //  System.out.println("dep " + c);

                    indegree[c]--;

                    if(indegree[c] == 0){
                        queue.add(c);
                    }
                }
            }
        }

        if(i == numCourses){
            return seq;
        }
        return new int[0];
    }
}
