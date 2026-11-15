class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort intervals based on end times
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));

        int[] lastInterval = intervals[0];
        
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            // overlap
            if (lastInterval[1] > intervals[i][0]) {
                result++;
                lastInterval[1] = Math.min(lastInterval[1], intervals[i][1]);
            } else {
                lastInterval[1] = intervals[i][1];
            }
        }
        return result;
    }
}
