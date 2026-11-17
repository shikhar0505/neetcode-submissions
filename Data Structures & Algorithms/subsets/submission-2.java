class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /*
            Iterative Approach
        Time complexity: O ( n * 2^n )
        */
        List<List<Integer>> sets = new ArrayList<>();
        sets.add(new ArrayList<>());

        for (int num : nums) {
            int n = sets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(sets.get(i));
                subset.add(num);
                sets.add(subset);
            }
        }
        return sets;

        /*
            DFS Approach

        Time complexity: O ( n * 2^n )
        */
        // List<List<Integer>> sets = new ArrayList<>();
        // dfs(nums, 0, new ArrayList<>(), sets);
        // return sets;
    }

    private void dfs(int[] nums, int i, List<Integer> curr, List<List<Integer>> sets) {
        if (i >= nums.length) {
            sets.add(new ArrayList<>(curr));
            return;
        }

        dfs(nums, i + 1, curr, sets);
        curr.add(nums[i]);
        dfs(nums, i + 1, curr, sets);
        curr.remove(curr.size() - 1);
    }
}
