class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int res = Integer.MAX_VALUE;
        String resString = "";
        int[] count1 = new int[128];
        int[] count2 = new int[128];

        for(int i=0;i<m; i++){
            count2[t.charAt(i)]++;
        }

        int l=0, start=0;
        int match=0;
        for(int r=0; r<n; r++){
            char c = s.charAt(r);
            count1[c]++;

            if(count2[c] > 0 && count1[c] <= count2[c]){
                match++;
            }

            while(m == match){ //valid

                if(r-l+1 < res){
                
                    res = r-l+1;
                    start = l;
                }

                count1[s.charAt(l)]--;

                if(count2[s.charAt(l)] > 0 && count1[s.charAt(l)] < count2[s.charAt(l)]){
                    match--;
                }
                l++;
            }

           // res = Math.min(res, r-l+1);
            resString = res == Integer.MAX_VALUE? "" : s.substring(start, start+res);
        }
        return resString;
    }
}
