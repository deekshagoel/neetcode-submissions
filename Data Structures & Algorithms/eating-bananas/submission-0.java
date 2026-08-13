class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 0, r = 0, res = 0;
        for(int i=0;i<piles.length;i++){
            r = Math.max(r, piles[i]);
        }

        while(l <= r){
            int mid = l+(r-l)/2;
            int hours = 0;
            for(int i = 0; i< piles.length; i++){
                hours += Math.ceil((double)piles[i]/mid);
            }

            if(hours <= h){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}
