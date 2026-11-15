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
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        
        // create a list of only start times, and another of only end times
        // sort both
        List<Integer> startTimes = intervals.stream().map(i -> i.start).sorted().toList();
        List<Integer> endTimes = intervals.stream().map(i -> i.end).sorted().toList();

        int maxRooms = 0;
        int count = 0;
        for (int i = 0, j = 0; i < startTimes.size() && j < endTimes.size();) {
            if (startTimes.get(i) < endTimes.get(j)) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            maxRooms = Math.max(maxRooms, count);
        }

        return maxRooms;
    }
}
