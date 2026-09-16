class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int total = n+m;
        int half = (total+1)/2;

        if(m < n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        System.out.println("hi " + n + m);

        int l = 0, r = nums1.length;
        System.out.println("hi A" + r);

        while(l<=r){
            int i = (l+r)/2;
            System.out.println("hi " + i);
            int j = half - i;

            int Aleft = i > 0 ? nums1[i-1] : Integer.MIN_VALUE;
            int Aright = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? nums2[j-1] : Integer.MIN_VALUE;
            int Bright = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                }else{
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2.0;
                }
            } else if (Aleft > Bright){
                r = i-1;
            }else{
                l = i+1;
            }
        }
        return -1;
    }
}
