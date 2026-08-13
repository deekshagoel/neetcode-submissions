class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0, maxFreq=0;
        int[] count = new int[26];

        int l = 0;
        for(int r=0; r<n; r++){
            count[s.charAt(r) - 'A']++; 
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

            int windowSize = r-l+1;

            while((r-l+1) - maxFreq > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
