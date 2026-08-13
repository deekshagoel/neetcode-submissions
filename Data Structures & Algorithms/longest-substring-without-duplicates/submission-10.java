class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res=0;
        HashMap<Character, Integer> count = new HashMap();
        int l=0;
        for(int r=0; r<n; r++){
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);


            while(count.getOrDefault(c, 0) > 1){
                
            count.put(s.charAt(l), count.getOrDefault(s.charAt(l), 0) - 1);
            l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
