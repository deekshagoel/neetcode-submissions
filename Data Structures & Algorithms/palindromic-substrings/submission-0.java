class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++){
            count += countPalin(s, i, i);

            count +=countPalin(s, i, i+1);
        }
        return count;
    }

    int countPalin(String s, int start, int end){
        int n = s.length();
        int count=0;
        while(start>=0 && end<n && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            count++;
        }
        return count;
    }
}
