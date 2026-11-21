class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        Intuition:
        - starting at last index, for every word in the dict, check it it matches
        */
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true; // out of bounds is valid

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() &&
                    s.substring(i, i + word.length()).equals(word)
                ) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
