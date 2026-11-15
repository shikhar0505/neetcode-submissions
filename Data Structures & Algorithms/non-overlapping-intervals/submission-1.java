class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort intervals based on end times
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));

        int lastIntervalEnd = intervals[0][1];
        
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            // overlap
            if (lastIntervalEnd > intervals[i][0]) {
                result++;
                // lastIntervalEnd = Math.min(lastIntervalEnd, intervals[i][1]);
            } else {
                lastIntervalEnd = intervals[i][1];
            }
        }
        return result;
    }
}
