1class Solution {
2    public int numIslands(char[][] grid) {
3        int count = 0;
4        for (int i = 0; i < grid.length; i++) {
5            for (int j = 0; j < grid[0].length; j++) {
6                if (grid[i][j] == '1') {
7                    count++;
8                    bfs(grid, i, j);
9                }
10            }
11        }
12        return count;
13    }
14    
15    private void bfs(char[][] grid, int i, int j) {
16        Queue<int[]> queue = new LinkedList<>();
17        queue.offer(new int[]{i, j});
18        grid[i][j] = '0';
19        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
20        while (!queue.isEmpty()) {
21            int[] cell = queue.poll();
22            for (int[] dir : directions) {
23                int newI = cell[0] + dir[0];
24                int newJ = cell[1] + dir[1];
25                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == '1') {
26                    queue.offer(new int[]{newI, newJ});
27                    grid[newI][newJ] = '0';
28                }
29            }
30        }
31    }
32}