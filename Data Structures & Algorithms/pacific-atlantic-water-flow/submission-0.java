class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList();
        int n = heights.length;
        int m = heights[0].length;

        int[][] pac = new int[n][m];
        int[][] atl = new int[n][m];

        for(int i=0; i<m; i++){
            dfs(0, i, pac, heights);
            dfs(n-1, i, atl, heights);
        }

        for(int i=0; i<n; i++){
            dfs(i, 0, pac, heights);
            dfs(i, m-1, atl, heights);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pac[i][j] == 1 && atl[i][j] ==1){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void dfs(int row, int col, int[][] ocean, int[][] heights){
        ocean[row][col] = 1;

        for(int[] dir:directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if(newrow>=0 && newrow<heights.length && newcol>=0 && newcol<heights[0].length && ocean[newrow][newcol] ==0
            && heights[newrow][newcol] >= heights[row][col]){
                dfs(newrow, newcol, ocean, heights);
            }
        }
    }
}
