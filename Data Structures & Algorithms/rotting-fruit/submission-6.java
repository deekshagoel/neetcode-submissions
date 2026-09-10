class Solution {
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> queue = new LinkedList();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
        while(size > 0){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir:directions){
                int newrow = row + dir[0];
                int newcol = col + dir[1];

                if(newrow<0 || newrow>=n || newcol<0|| newcol >=m 
                || grid[newrow][newcol] != 1)
                    continue;

                queue.add(new int[]{newrow, newcol});
                
                grid[newrow][newcol] = 2;
            }
            size--;
        }
        if(queue.size() > 0){
            time++;
        }
            System.out.println("size " + queue.size());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return time;
    }
}
