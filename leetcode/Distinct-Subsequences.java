1class Solution {
2    public int numDistinct(String s, String t) {
3        int n = s.length(), m = t.length();
4        int[][] dp = new int[n + 1][m + 1];
5        for (int i = 0; i <= n; i++) {
6            dp[i][0] = 1;
7        }
8        for (int i = 1; i <= n; i++) {
9            char cs = s.charAt(i - 1);
10            for (int j = 1; j <= m; j++) {
11                dp[i][j] = dp[i - 1][j];
12                if (cs == t.charAt(j - 1)) {
13                    dp[i][j] += dp[i - 1][j - 1];
14                }
15            }
16        }
17        return dp[n][m];
18    }
19}