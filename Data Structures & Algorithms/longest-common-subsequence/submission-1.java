class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(text1, text2, 0, 0);
    }

    int lcs(String s, String t, int i, int j){
        if(i>=s.length() || j>=t.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
           dp[i][j] = 1 + lcs(s, t, i+1, j+1);
        }
        else{
        dp[i][j] = Math.max(lcs(s, t, i, j+1) , lcs(s, t, i+1, j));
        }
        return dp[i][j];
    }
}
