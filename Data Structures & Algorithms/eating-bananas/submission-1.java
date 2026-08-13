class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n =piles.length;
        int rate = 0;
        for(int i=0;i<n;i++){
            rate=Math.max(rate, piles[i]);
        }

        int l=1, res=rate;
        while(l<=rate){
            int mid = l + (rate - l)/2;

            long hours = 0;
            for(int i=0;i<n;i++){
                hours += Math.ceil((double)piles[i]/mid); 
            }

            if(hours <= h){
                res=mid;
                rate = mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}
