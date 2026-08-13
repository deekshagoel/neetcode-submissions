class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int maxWindow = 0, window;
        int l = 0;
        HashMap<Character, Integer> count = new HashMap();

        for(int r=0; r<n; r++){
            //char sr = s.charAt(r);
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0)+1);
            while(count.getOrDefault(s.charAt(r), 0)>1){
                count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }
            window = r-l+1;
            maxWindow = Math.max(maxWindow, window);
        }

        return maxWindow;
    }
}
