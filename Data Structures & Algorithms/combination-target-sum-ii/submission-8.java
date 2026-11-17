class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        // sort so all duplicates are grouped together
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> curr, int i) {
        int sum = curr.stream().reduce(0, Integer::sum);
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target || i >= candidates.length) {
            // candidates aren't negative
            return;
        }
        
        curr.add(candidates[i]);
        dfs(candidates, target, result, curr, i + 1);
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, target, result, curr, i + 1);
    }
}
