class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][n] = suffix[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                for (int k = 1; k <= 2 * j && i + k <= n; k++) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            suffix[i] - dp[i + k][Math.max(j, k)]);
                }
            }
        }
        return dp[0][1];
    }
}