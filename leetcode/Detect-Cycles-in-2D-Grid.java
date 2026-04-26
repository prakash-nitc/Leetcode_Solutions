1class Solution {
2    private int rows;
3    private int cols;
4    private char[][] grid;
5    private boolean[][] visited;
6
7    // Directions: up, right, down, left
8    private final int[] dx = {-1, 0, 1, 0};
9    private final int[] dy = {0, 1, 0, -1};
10
11    public boolean containsCycle(char[][] grid) {
12        this.rows = grid.length;
13        this.cols = grid[0].length;
14        this.grid = grid;
15        this.visited = new boolean[rows][cols];
16
17        // Try to start DFS from every unvisited cell
18        for (int i = 0; i < rows; i++) {
19            for (int j = 0; j < cols; j++) {
20                if (!visited[i][j]) {
21                    if (dfs(i, j, -1, -1, grid[i][j])) {
22                        return true;
23                    }
24                }
25            }
26        }
27        return false;
28    }
29
30    private boolean dfs(int x, int y, int px, int py, char color) {
31        visited[x][y] = true;
32
33        for (int dir = 0; dir < 4; dir++) {
34            int nx = x + dx[dir];
35            int ny = y + dy[dir];
36
37            // Check bounds
38            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
39                continue;
40            }
41
42            // Must be same color
43            if (grid[nx][ny] != color) {
44                continue;
45            }
46
47            // Skip coming back to the immediate parent
48            if (nx == px && ny == py) {
49                continue;
50            }
51
52            // If neighbor is already visited and it's not the parent -> cycle
53            if (visited[nx][ny]) {
54                return true;
55            }
56
57            // Continue DFS
58            if (dfs(nx, ny, x, y, color)) {
59                return true;
60            }
61        }
62        return false;
63    }
64}