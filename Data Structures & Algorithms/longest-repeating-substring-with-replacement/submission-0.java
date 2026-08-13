class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character, Integer> count = new HashMap();
        int n = s.length();
        int l=0, res=0, maxF=0;
        int r=0;
        while(r<n){

            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

            maxF= Math.max(maxF, count.get(s.charAt(r)));
            int window = r-l+1;
            while(window - maxF > k){
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
                window--;
            }
            res = Math.max(res, window);
            r++;
        }

        return res;
    }
}
