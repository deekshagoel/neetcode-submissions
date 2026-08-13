class Solution {

    int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; 
        int n=grid.length;
        int m=grid[0].length;
        int area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                   maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    int dfs(int[][] grid, int row, int col){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length
        || grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;
        int res = 1;
        for(int i=0; i<4; i++){
            res += dfs(grid, row + dir[i][0], col + dir[i][1]);
        }
        return res;
    }
}
