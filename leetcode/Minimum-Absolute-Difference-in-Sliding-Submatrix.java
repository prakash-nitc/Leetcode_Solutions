1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int rows = m - k + 1;
6        int cols = n - k + 1;
7        int[][] ans = new int[rows][cols];
8
9        // For each k x k submatrix
10        for (int i = 0; i < rows; i++) {
11            for (int j = 0; j < cols; j++) {
12
13                // Collect all elements of this submatrix into an array
14                int size = k * k;
15                int[] arr = new int[size];
16                int idx = 0;
17                for (int r = i; r < i + k; r++) {
18                    for (int c = j; c < j + k; c++) {
19                        arr[idx++] = grid[r][c];
20                    }
21                }
22
23                // Sort and find minimum absolute difference between adjacent distinct values
24                java.util.Arrays.sort(arr);
25                int best = Integer.MAX_VALUE;
26                for (int t = 1; t < size; t++) {
27                    if (arr[t] != arr[t - 1]) {
28                        best = Math.min(best, arr[t] - arr[t - 1]);
29                    }
30                }
31
32                // If all equal, answer should be 0
33                ans[i][j] = (best == Integer.MAX_VALUE) ? 0 : best;
34            }
35        }
36
37        return ans;
38    }
39}
40