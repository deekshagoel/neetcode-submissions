class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];
        int island = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && visited[i][j]==0){
                    dfs(grid, visited, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    void dfs(char[][] grid, int[][] visited, int row, int col){
        visited[row][col] = 1;
        for(int[] dir : directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if(newrow>=0 && newrow<grid.length && 
            newcol>=0 && newcol<grid[0].length && visited[newrow][newcol]==0
            && grid[newrow][newcol]=='1'){
                dfs(grid, visited, newrow, newcol);
            }
        }
    }
}
