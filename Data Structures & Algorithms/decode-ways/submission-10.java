class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                
                if (i + 1 < s.length() &&
                    (s.charAt(i) == '1' ||
                        (s.charAt(i) == '2' && s.charAt(i + 1) < '7')
                    )
                ) {
                    // both cases exist → add them
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    // only single-digit case → one contributor
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }
}
