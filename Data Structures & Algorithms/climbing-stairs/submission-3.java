class Solution {
    Map<Integer, Integer> dp = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int numWays = climbStairs(n - 1) + climbStairs(n - 2);
        dp.put(n, numWays);
        return numWays;
    }
}
