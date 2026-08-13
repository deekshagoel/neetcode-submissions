class Solution {
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        
        for(int c=0; c<m; c++){
            dfs(board, 0, c);
            dfs(board, n-1, c);
        }

        for(int r=0; r<n; r++){
            dfs(board, r, 0);
            dfs(board, r, m-1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int row, int col){
        
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] != 'O'){
            return;
        }

        board[row][col] = 'T';
        
        dfs(board, row+1, col);
        dfs(board, row, col+1);
        dfs(board, row-1, col);
        dfs(board, row, col-1);
        }
}

