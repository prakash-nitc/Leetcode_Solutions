1import java.util.Arrays;
2
3class Solution {
4    private static final int MOD = (int)1e9 + 7;
5
6    public int numberOfPaths(int[][] grid, int k) {
7        int m = grid.length;
8        int n = grid[0].length;
9
10        // dp[i][j][r] = number of paths from (i,j) to (m-1,n-1) with sum % k == r
11        int[][][] dp = new int[m][n][k];
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                Arrays.fill(dp[i][j], -1);
15            }
16        }
17
18        return dfs(0, 0, 0, grid, k, dp);
19    }
20
21    private int dfs(int i, int j, int rem, int[][] grid, int k, int[][][] dp) {
22        int m = grid.length;
23        int n = grid[0].length;
24
25        if (i >= m || j >= n) return 0;
26
27        rem = (rem + grid[i][j]) % k;
28
29        if (dp[i][j][rem] != -1) return dp[i][j][rem];
30
31        if (i == m - 1 && j == n - 1) {
32            return dp[i][j][rem] = (rem == 0 ? 1 : 0);
33        }
34
35        long ways = 0;
36        ways += dfs(i + 1, j, rem, grid, k, dp); // down
37        ways += dfs(i, j + 1, rem, grid, k, dp); // right
38        ways %= MOD;
39
40        dp[i][j][rem] = (int) ways;
41        return dp[i][j][rem];
42    }
43}
44