class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, target, new ArrayList<>(), result, 0);

        return result;
    }

    private void dfs(int[] nums, int target, List<Integer> subset, List<List<Integer>> result, int i) {
        int sum = subset.stream().reduce(0, Integer::sum);
        if (sum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (sum > target || i >= nums.length) {
            return;
        }
        subset.add(nums[i]);
        dfs(nums, target, subset, result, i);
        subset.remove(subset.size() - 1);
        dfs(nums, target, subset, result, i + 1);
    }
}
