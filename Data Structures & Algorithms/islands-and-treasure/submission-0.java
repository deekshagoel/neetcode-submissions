class Solution {
    public void islandsAndTreasure(int[][] grid) {
        
        int[][] directions = new int[][]{{-1, 0},{0, 1}, {1, 0}, {0, -1}};
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
            for(int[] dir: directions){
                int newR = row + dir[0];
                int newC = col + dir[1];

                if(newR<0 || newR>=n || newC<0 || newC>=m || 
                grid[newR][newC] != Integer.MAX_VALUE){
                    continue;
                }
                queue.add(new int[]{newR, newC});
                grid[newR][newC] = grid[row][col] + 1;
            }
        }

    }
}
