class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
        }

        if (i >= nums.length) {
            return;
        }
        subset.add(nums[i]);
        dfs(nums, result, subset, i + 1);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }

        dfs(nums, result, subset, i + 1);
    }
}
