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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }

        // sort intervals based on start times
        intervals.sort(Comparator.comparing(i -> i.start));

        Interval latest = intervals.getFirst();
        for (int i = 1; i < intervals.size(); i++) {
            if (latest.end > intervals.get(i).start) {
                return false;
            }
            latest = intervals.get(i);
        }

        return true;
    }
}
