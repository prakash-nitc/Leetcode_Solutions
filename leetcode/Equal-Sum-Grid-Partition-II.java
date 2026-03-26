1import java.util.*;
2
3class Solution {
4    private boolean canRemove(int r1, int c1, int r2, int c2, int i, int j) {
5        int rows = r2 - r1 + 1;
6        int cols = c2 - c1 + 1;
7
8        if (rows * cols == 1) return false;
9
10        if (rows == 1) {
11            return (j == c1 || j == c2);
12        }
13
14        if (cols == 1) {
15            return (i == r1 || i == r2);
16        }
17
18        return true;
19    }
20
21    public boolean canPartitionGrid(int[][] grid) {
22        int n = grid.length;
23        int m = grid[0].length;
24
25        long[] prefRow = new long[n];
26        long[] prefCol = new long[m];
27
28        Map<Long, List<int[]>> mp = new HashMap<>();
29
30        for (int i = 0; i < n; i++) {
31            long val = 0;
32            for (int j = 0; j < m; j++) {
33                val += grid[i][j];
34                long cellVal = (long) grid[i][j];
35                mp.putIfAbsent(cellVal, new ArrayList<>());
36                mp.get(cellVal).add(new int[]{i, j});
37            }
38            prefRow[i] = val + (i > 0 ? prefRow[i - 1] : 0);
39        }
40
41        for (int j = 0; j < m; j++) {
42            long val = 0;
43            for (int i = 0; i < n; i++) {
44                val += grid[i][j];
45            }
46            prefCol[j] = val + (j > 0 ? prefCol[j - 1] : 0);
47        }
48
49        long total = prefRow[n - 1];
50
51        for (int i = 0; i < n - 1; i++) {
52            long top = prefRow[i];
53            long bottom = total - top;
54
55            if (top == bottom) return true;
56
57            long diff = Math.abs(top - bottom);
58
59            if (!mp.containsKey(diff)) continue;
60
61            if (top > bottom) {
62                for (int[] p : mp.get(diff)) {
63                    int x = p[0], y = p[1];
64                    if (x <= i && canRemove(0, 0, i, m - 1, x, y)) {
65                        return true;
66                    }
67                }
68            } else {
69                for (int[] p : mp.get(diff)) {
70                    int x = p[0], y = p[1];
71                    if (x > i && canRemove(i + 1, 0, n - 1, m - 1, x, y)) {
72                        return true;
73                    }
74                }
75            }
76        }
77
78        for (int j = 0; j < m - 1; j++) {
79            long left = prefCol[j];
80            long right = total - left;
81
82            if (left == right) return true;
83
84            long diff = Math.abs(left - right);
85
86            if (!mp.containsKey(diff)) continue;
87
88            if (left > right) {
89                for (int[] p : mp.get(diff)) {
90                    int x = p[0], y = p[1];
91                    if (y <= j && canRemove(0, 0, n - 1, j, x, y)) {
92                        return true;
93                    }
94                }
95            } else {
96                for (int[] p : mp.get(diff)) {
97                    int x = p[0], y = p[1];
98                    if (y > j && canRemove(0, j + 1, n - 1, m - 1, x, y)) {
99                        return true;
100                    }
101                }
102            }
103        }
104
105        return false;
106    }
107}