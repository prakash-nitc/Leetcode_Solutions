1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int MOD = 1_000_000_007;
4        int m = grid.length, n = grid[0].length;
5
6        long[][] maxProd = new long[m][n];
7        long[][] minProd = new long[m][n];
8
9        maxProd[0][0] = minProd[0][0] = grid[0][0];
10
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                if (i == 0 && j == 0) continue;
14
15                long maxVal = Long.MIN_VALUE;
16                long minVal = Long.MAX_VALUE;
17
18                if (i > 0) {
19                    maxVal = Math.max(maxVal, maxProd[i - 1][j]);
20                    minVal = Math.min(minVal, minProd[i - 1][j]);
21                }
22                if (j > 0) {
23                    maxVal = Math.max(maxVal, maxProd[i][j - 1]);
24                    minVal = Math.min(minVal, minProd[i][j - 1]);
25                }
26
27                long val = grid[i][j];
28                if (val >= 0) {
29                    maxProd[i][j] = maxVal * val;
30                    minProd[i][j] = minVal * val;
31                } else {
32                    maxProd[i][j] = minVal * val;
33                    minProd[i][j] = maxVal * val;
34                }
35            }
36        }
37
38        long res = maxProd[m - 1][n - 1];
39        if (res < 0) return -1;
40        return (int) (res % MOD);
41    }
42}
43