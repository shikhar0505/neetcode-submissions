class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, result, new StringBuilder(), 0, 0);
        return result;
    }

    private void dfs(int n, List<String> result, StringBuilder curr, int open, int close) {
        if (n == open && open == close) {
            result.add(curr.toString());
            return;
        }
        
        if (open < n) {
            curr.append("(");
            dfs(n, result, curr, open + 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(")");
            dfs(n, result, curr, open, close + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
