/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int rooms = 0, result = 0, i=0;
        int[] start = new int[n];
        int[] end = new int[n];
        for(Interval interval : intervals){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int s=0, e=0;
        while(s < n){
            if(start[s]<end[e]){
                rooms++;
                s++;
            }else{
                rooms--;
                e++;
            }
            result = Math.max(result, rooms);
        }
        return result;
    }
}
