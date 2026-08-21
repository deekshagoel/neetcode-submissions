class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        return ways(m, n, m-1, n-1);
    }

    int ways(int m, int n, int i, int j){
        if(i<0 || j<0){
            return 0;
        }

        if(i==0 && j==0){
            return 1;
        }

        if(dp[i][j] != 0){
            return dp[i][j];
        }
        dp[i][j] = ways(m,n, i, j-1) + ways(m, n, i-1, j);
        return dp[i][j];
    }
}
