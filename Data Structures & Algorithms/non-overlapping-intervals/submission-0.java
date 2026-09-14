class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
            
        int n = intervals.length;
        if(intervals.length <= 1){
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList();
        result.add(intervals[0]);
        for(int i=1; i<n; i++){
            int[] last = result.get(result.size()-1);

            if(intervals[i][0] >= last[1]){
                result.add(intervals[i]);
            }else{
                last[1] = Math.min(last[1], intervals[i][1]);
            }
        }
        int[][] res = result.toArray(new int[0][]);
        return intervals.length - res.length;

    }
}
