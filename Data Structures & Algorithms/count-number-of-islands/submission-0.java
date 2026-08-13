class Solution {
    int[][] direction = {{-1,0}, {0, 1} ,{1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int islands=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    //grid[i][j] = '0';
                    dfs(grid, i, j, islands);
                    islands++;
                }
            }
        }
        return islands;
    }
    int dfs(char[][] grid, int row, int col, int islands){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] =='0'){
            return 0;
        }
        grid[row][col] = '0';
        for(int i=0; i<4; i++){
            int nr = row + direction[i][0];
            int nc = col + direction[i][1];

                
                dfs(grid, nr, nc, islands);
        }
        return islands;
    }
}
