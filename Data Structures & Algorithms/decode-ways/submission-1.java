class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decode(s, 0);
    }

    int decode(String s, int i){
        if(i>=s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }


        if(dp[i] != -1){
            return dp[i];
        }
        int res = decode(s, i+1);
        if(i<s.length()-1){
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' &&s.charAt(i+1)<'7')){
                res += decode(s, i+2);
            }
        }
        dp[i] = res;
        return dp[i];
    }
}
