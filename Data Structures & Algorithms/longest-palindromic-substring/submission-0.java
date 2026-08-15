class Solution {
    public String longestPalindrome(String s) {
      int n = s.length();
      int longest = 0;
      int start=0;
      for(int i=0;i<n;i++){
        int odd = countPalin(s, i, i);
        int even = countPalin(s, i, i+1);

        int len = Math.max(odd, even);
        if(len>longest){
            longest=len;
            start = i - (longest-1)/2;
        }
      }
      return s.substring(start, start+longest);  
    }

    int countPalin(String s, int start, int end){
        int n=s.length();

        while(start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }
}
