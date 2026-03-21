1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        int top = x;
4        int bottom = x + k - 1;
5
6        while (top < bottom) {
7            for (int col = y; col < y + k; col++) {
8                int temp = grid[top][col];
9                grid[top][col] = grid[bottom][col];
10                grid[bottom][col] = temp;
11            }
12            top++;
13            bottom--;
14        }
15
16        return grid;
17    }
18}
19