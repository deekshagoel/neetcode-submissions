class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap();
        int l=0;
        int maxF=0;
        int res=0;

        for(int r=0; r<n; r++){
            char right = s.charAt(r);
            hm.put(right, hm.getOrDefault(right, 0) + 1);
            maxF = Math.max(maxF, hm.get(right));
            //System.out.println(maxF + " " + right + " " + hm.get(r));
            int window = r-l+1;

            while((r-l+1) - maxF > k){
                //System.out.println("Invalid");
                char left = s.charAt(l);
                hm.put(left, hm.getOrDefault(left, 0) - 1);

                for(int freq:hm.values()){
                    maxF = Math.max(maxF, freq);
                }
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
