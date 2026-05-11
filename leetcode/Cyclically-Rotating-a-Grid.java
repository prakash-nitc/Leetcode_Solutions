1class Solution {
2    public int[][] rotateGrid(int[][] grid, int k) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int layers = Math.min(m, n) / 2;
6        for (int layer = 0; layer < layers; layer++) {
7            int top = layer;
8            int left = layer;
9            int bottom = m - layer - 1;
10            int right = n - layer - 1;
11
12            java.util.List<Integer> vals = new java.util.ArrayList<>();
13            for (int j = left; j <= right; j++) vals.add(grid[top][j]);
14            for (int i = top + 1; i <= bottom - 1; i++) vals.add(grid[i][right]);
15            for (int j = right; j >= left; j--) vals.add(grid[bottom][j]);
16            for (int i = bottom - 1; i >= top + 1; i--) vals.add(grid[i][left]);
17
18            int len = vals.size();
19            int rot = k % len;
20            java.util.List<Integer> rotated = new java.util.ArrayList<>(len);
21            for (int i = 0; i < len; i++) {
22                rotated.add(vals.get((i + rot) % len));
23            }
24
25            int idx = 0;
26            for (int j = left; j <= right; j++) grid[top][j] = rotated.get(idx++);
27            for (int i = top + 1; i <= bottom - 1; i++) grid[i][right] = rotated.get(idx++);
28            for (int j = right; j >= left; j--) grid[bottom][j] = rotated.get(idx++);
29            for (int i = bottom - 1; i >= top + 1; i--) grid[i][left] = rotated.get(idx++);
30        }
31        return grid;
32    }
33}