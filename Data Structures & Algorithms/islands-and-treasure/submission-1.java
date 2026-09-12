class Solution {
    
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] dir:directions){
                int newrow = row + dir[0];
                int newcol = col + dir[1];

                if(newrow<0 || newrow>=n || newcol<0
                || newcol>=m || grid[newrow][newcol]!=Integer.MAX_VALUE){
                    continue;
                }

                grid[newrow][newcol] = 1 + grid[row][col];

                queue.add(new int[]{newrow, newcol});
            }
        }






    }
}
