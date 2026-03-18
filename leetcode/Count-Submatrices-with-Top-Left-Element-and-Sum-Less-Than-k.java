1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        // prefix[i][j] = sum of submatrix (0,0) to (i,j), inclusive
7        long[][] prefix = new long[m][n];
8        int count = 0;
9
10        for (int i = 0; i < m; i++) {
11            long rowSum = 0;
12            for (int j = 0; j < n; j++) {
13                rowSum += grid[i][j];
14                prefix[i][j] = rowSum;
15                if (i > 0) {
16                    prefix[i][j] += prefix[i - 1][j];
17                }
18
19                // submatrix is always from (0,0) to (i,j)
20                if (prefix[i][j] <= k) {
21                    count++;
22                }
23            }
24        }
25
26        return count;
27    }
28}
29