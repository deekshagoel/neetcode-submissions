class Solution {
    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                    if(dfs(board, i, j, word, 0, visited)){
                        return true;
                    }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int row, int col, String word, int idx, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }

    if(row<0 || row>=board.length || col<0 || col>=board[0].length
    || board[row][col] != word.charAt(idx) || visited[row][col] == true){
                return false;
            }
               
        visited[row][col] = true;
        
        boolean res = dfs(board, row-1, col, word, idx+1, visited)
                    || dfs(board, row, col+1, word, idx+1, visited)
                    || dfs(board, row+1, col, word, idx+1, visited)
                    || dfs(board, row, col-1, word, idx+1, visited);
        visited[row][col] = false;
        return res;
    }
}
