1import java.util.*;
2
3class Solution {
4    public int[] getBiggestThree(int[][] grid) {
5        int m = grid.length, n = grid[0].length;
6        TreeSet<Integer> set = new TreeSet<>();
7
8        for (int r = 0; r < m; r++) {
9            for (int c = 0; c < n; c++) {
10                // size 0 rhombus (single cell)
11                set.add(grid[r][c]);
12
13                int maxK = Math.min(Math.min(r, m - 1 - r), Math.min(c, n - 1 - c));
14                for (int k = 1; k <= maxK; k++) {
15                    int sum = borderSum(grid, r, c, k);
16                    set.add(sum);
17                }
18            }
19        }
20
21        List<Integer> list = new ArrayList<>(set.descendingSet());
22        int size = Math.min(3, list.size());
23        int[] ans = new int[size];
24        for (int i = 0; i < size; i++) ans[i] = list.get(i);
25        return ans;
26    }
27
28    // walk the border of rhombus with center (r,c) and radius k
29    private int borderSum(int[][] g, int r, int c, int k) {
30        int sum = 0;
31
32        int x = r - k, y = c;         // top
33        // top -> right-down
34        for (int i = 0; i < k; i++) {
35            sum += g[x + i][y + i];
36        }
37
38        x = r; y = c + k;             // right
39        // right -> bottom-down-left
40        for (int i = 0; i < k; i++) {
41            sum += g[x + i][y - i];
42        }
43
44        x = r + k; y = c;             // bottom
45        // bottom -> left-up-left
46        for (int i = 0; i < k; i++) {
47            sum += g[x - i][y - i];
48        }
49
50        x = r; y = c - k;             // left
51        // left -> top-up-right
52        for (int i = 0; i < k; i++) {
53            sum += g[x - i][y + i];
54        }
55
56        return sum;
57    }
58}
59