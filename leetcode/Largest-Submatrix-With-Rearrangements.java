1import java.util.*;
2
3class Solution {
4    public int largestSubmatrix(int[][] matrix) {
5        int m = matrix.length;
6        int n = matrix[0].length;
7
8        // heights[i][j] = number of consecutive 1s ending at row i in column j
9        int[][] heights = new int[m][n];
10
11        // Build heights matrix
12        for (int j = 0; j < n; ++j) {
13            heights[0][j] = matrix[0][j];
14            for (int i = 1; i < m; ++i) {
15                if (matrix[i][j] == 0) {
16                    heights[i][j] = 0;
17                } else {
18                    heights[i][j] = heights[i - 1][j] + 1;
19                }
20            }
21        }
22
23        int maxArea = 0;
24
25        // For each row, sort the heights and compute best area
26        for (int i = 0; i < m; ++i) {
27            int[] row = heights[i].clone();
28            Arrays.sort(row); // ascending
29
30            // After sort, for each position k, we can take width = n - k,
31            // height = row[k] (because we can rearrange columns)
32            for (int k = n - 1; k >= 0; --k) {
33                int h = row[k];
34                if (h == 0) break; // no larger area possible with h=0
35                int width = n - k;
36                maxArea = Math.max(maxArea, h * width);
37            }
38        }
39
40        return maxArea;
41    }
42}
43