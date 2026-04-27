1class Solution {
2    // directions: up, right, down, left
3    private static final int[][] DIRS = {{-1,0}, {0,1}, {1,0}, {0,-1}};
4
5    // For each street type, which directions can we go? (0=up,1=right,2=down,3=left)
6    private static final int[][] TYPE_DIRS = {
7        {},             // 0 (unused)
8        {1, 3},         // 1: left <-> right
9        {0, 2},         // 2: up   <-> down
10        {3, 2},         // 3: left <-> down
11        {1, 2},         // 4: right <-> down
12        {0, 3},         // 5: up   <-> left
13        {0, 1}          // 6: up   <-> right
14    };
15
16    // For each direction, which street types in the neighbor can accept a connection?
17    // neighborAccept[d] = list of street types that have opening opposite to d
18    private static final int[][] NEIGHBOR_ACCEPT = {
19        // from current going up (0): neighbor must have opening down -> types 2,3,4
20        {2, 3, 4},
21        // right (1): neighbor must have opening left -> types 1,3,5
22        {1, 3, 5},
23        // down (2): neighbor must have opening up -> types 2,5,6
24        {2, 5, 6},
25        // left (3): neighbor must have opening right -> types 1,4,6
26        {1, 4, 6}
27    };
28
29    public boolean hasValidPath(int[][] grid) {
30        int m = grid.length, n = grid[0].length;
31        boolean[][] vis = new boolean[m][n];
32        return dfs(grid, 0, 0, vis, m, n);
33    }
34
35    private boolean dfs(int[][] grid, int r, int c, boolean[][] vis, int m, int n) {
36        if (r == m - 1 && c == n - 1) return true;
37        vis[r][c] = true;
38
39        int type = grid[r][c];
40        for (int d : TYPE_DIRS[type]) {
41            int nr = r + DIRS[d][0];
42            int nc = c + DIRS[d][1];
43
44            if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc]) continue;
45
46            int nextType = grid[nr][nc];
47            if (canConnect(d, nextType) && dfs(grid, nr, nc, vis, m, n)) {
48                return true;
49            }
50        }
51        return false;
52    }
53
54    // Check if neighbor's street type has an opening opposite to direction d
55    private boolean canConnect(int d, int neighborType) {
56        for (int t : NEIGHBOR_ACCEPT[d]) {
57            if (t == neighborType) return true;
58        }
59        return false;
60    }
61}
62