class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();
        int l=0;
        int maxF=0, res=0;
        HashMap<Character, Integer> map = new HashMap();
        for(int r=0;r<n;r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));

            int windowSize = r-l+1;

            while((r-l+1) - maxF > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);

                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
