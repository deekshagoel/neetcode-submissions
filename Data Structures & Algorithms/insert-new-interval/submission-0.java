class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> result = new ArrayList();
        int target = newInterval[0];

        int l=0, r=intervals.length-1;

        while(l<=r){
            int mid = l + (r-l)/2;

            if(intervals[mid][0] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        for(int i=0;i<l;i++){
            result.add(intervals[i]);
        }
        result.add(newInterval);

        for(int i=l; i<intervals.length;i++){
            result.add(intervals[i]);
        }

        List<int[]> merged = new ArrayList();
        merged.add(result.get(0));

        for(int i=0;i<result.size();i++){

            int start = result.get(i)[0];
            int end = result.get(i)[1];

            int lastEnd = merged.get(merged.size()-1)[1];

            if(start<=lastEnd){
                merged.get(merged.size()-1)[1] = Math.max(end, merged.get(merged.size()-1)[1]);
            }else{
                 merged.add(result.get(i));
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
