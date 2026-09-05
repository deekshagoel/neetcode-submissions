class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
       return countWays(s, 0, dp);
    }

    int countWays(String s, int index, int[] dp){

        if(index>=s.length()){
            return 1;
        }

        if(dp[index] != 0){
            return dp[index];
        }

        //int count = 0;
        char ch = s.charAt(index);
        if(ch == '0'){
            return 0;
        }

        dp[index] += countWays(s, index+1, dp);
        
        if(index+1 < s.length()){

            int num = (s.charAt(index) - '0') * 10 + (s.charAt(index+1) - '0');

            if(num>=10 && num<=26){
                dp[index] += countWays(s, index+2, dp);
            }
        }
       // dp[index] = count;
        return dp[index];
    }
}
