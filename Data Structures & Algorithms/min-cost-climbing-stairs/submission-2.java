class Solution {
    private Map<Integer, Integer> dp = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    private int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        int res = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
        dp.put(i, res);
        return res;
    }
}
