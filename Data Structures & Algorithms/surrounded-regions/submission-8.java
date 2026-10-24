class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<n; i++){
            if(board[0][i] == 'O')
                dfs(board, 0, i, m, n);
            if(board[m-1][i] == 'O')
                dfs(board, m-1, i, m, n);
            
        }

        for(int i=0; i<m; i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0, m, n);
            if(board[i][n-1] == 'O')
                dfs(board, i, n-1, m, n);
        }

        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                if(board[i][j] == 'Z'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    void dfs(char[][] board, int row, int col, int m, int n){
        board[row][col] = 'Z';

        for(int[] dir:directions){
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;

            if(newRow<0 || newRow>=m|| newCol<0 || newCol>=n 
            || board[newRow][newCol] == 'X' || board[newRow][newCol] == 'Z'){
                continue;
            }
            if(board[newRow][newCol] == 'O'){
                dfs(board, newRow, newCol, m, n);
            }
        }
    }
}
