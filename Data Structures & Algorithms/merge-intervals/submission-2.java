class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        res.add(intervals[0]);

        //int[][] first = intervals[0][];

        int i = 1;

        while(i<intervals.length){

            if(res.get(res.size()-1)[1]<intervals[i][0]){
                res.add(intervals[i]);
            }else{
                int[] last =  res.get(res.size()-1);
                res.get(res.size()-1)[1] = Math.max(last[1], intervals[i][1]);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
