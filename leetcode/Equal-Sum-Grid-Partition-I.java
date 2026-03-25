1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        long total = 0L;
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                total += grid[i][j];
10            }
11        }
12
13        // If total sum is odd, we cannot split into two equal integer sums
14        if ((total & 1L) == 1L) return false;
15
16        long target = total / 2L;
17
18        // Check horizontal cuts: between row r and r+1 (0 <= r < m-1)
19        long prefix = 0L;
20        for (int i = 0; i < m - 1; i++) {
21            for (int j = 0; j < n; j++) {
22                prefix += grid[i][j];
23            }
24            if (prefix == target) return true;
25        }
26
27        // Check vertical cuts: between col c and c+1 (0 <= c < n-1)
28        long[] colPrefix = new long[n];
29        for (int i = 0; i < m; i++) {
30            for (int j = 0; j < n; j++) {
31                colPrefix[j] += grid[i][j];
32            }
33        }
34
35        long running = 0L;
36        for (int j = 0; j < n - 1; j++) {
37            running += colPrefix[j];
38            if (running == target) return true;
39        }
40
41        return false;
42    }
43}
44