1class Solution {
2    public double champagneTower(int poured, int query_row, int query_glass) {
3        // dp[r][c] = amount of champagne in glass (r, c)
4        double[][] dp = new double[query_row + 2][query_row + 2];
5        dp[0][0] = poured;
6
7        for (int r = 0; r <= query_row; r++) {
8            for (int c = 0; c <= r; c++) {
9                if (dp[r][c] > 1.0) {
10                    double extra = dp[r][c] - 1.0;
11                    dp[r][c] = 1.0;
12                    dp[r + 1][c]     += extra / 2.0;
13                    dp[r + 1][c + 1] += extra / 2.0;
14                }
15            }
16        }
17
18        return Math.min(1.0, dp[query_row][query_glass]);
19    }
20}
21