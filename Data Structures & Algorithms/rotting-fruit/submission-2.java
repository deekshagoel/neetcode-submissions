class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] directions = new int[][]{{-1,0}, {0, 1}, {1, 0}, {0, -1}};

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        int time = 0;
        boolean rotten = false;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        
        while(!queue.isEmpty()){
            int size = queue.size();
            rotten = false;
            System.out.println("Queue size"+ queue.size());
            for(int i=0; i<size; i++){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions){
                int row = r + dir[0];
                int col = c + dir[1];

                if(row<0 || row>=n
                || col<0 || col>=m
                || grid[row][col] != 1){
                    continue;
                }

                queue.add(new int[]{row, col});
                grid[row][col] = 2;
                rotten = true;
            }
            }
            if(rotten == true){
                time++;
            }
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
