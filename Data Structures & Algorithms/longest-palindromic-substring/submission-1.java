class Solution {
    public String longestPalindrome(String s) {
        
        int max = 0, end=-1, start2=-1, len =0;
        int n = s.length();

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int l=i, r=j;

                while(l>=0 && r<n && l<r && s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }

                if(l>=r && j-i+1>max){
                    max = j-i+1;
                    start2 = i;
                    end = j;
                }
                }
            }

            return s.substring(start2, end+1);
    }
}
