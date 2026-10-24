class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;

        if(n==0 || n==1){
            return intervals;
        }
                Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));


        List<int[]> merged = new ArrayList();
        merged.add(intervals[0]);

        for(int i=1; i<n; i++){
            if(merged.get(merged.size()-1)[1] < intervals[i][0]){
                merged.add(intervals[i]);
            }else{
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], intervals[i][1]);
                
            }
            }
            return merged.toArray(new int[0][]);
        }
    
}
