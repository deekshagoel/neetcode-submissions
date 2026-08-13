class Solution {


    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];

       for(int i=n-2;i>=0;i--){
        int j = i+1;

        while(j < n && temperatures[j] <= temperatures[i]){
            System.out.println(temperatures[j] + " " + res[j]);
            if(res[j] == 0){
                res[i] = 0;
                break;
            }
            j += res[j];
        }
        
        if(j<n && temperatures[j] > temperatures[i]){
            res[i] = j-i;
        }
       }
        
    return res;
    }
}
