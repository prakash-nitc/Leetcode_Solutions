1import java.util.*;
2
3class Solution {
4    public int minOperations(int[][] grid, int x) {
5        int m = grid.length;
6        int n = grid[0].length;
7        int[] arr = new int[m * n];
8        int idx = 0;
9        int rem = grid[0][0] % x;
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (grid[i][j] % x != rem) return -1;
13                arr[idx++] = grid[i][j];
14            }
15        }
16        Arrays.sort(arr);
17        int median = arr[arr.length / 2];
18        int ops = 0;
19        for (int val : arr) {
20            ops += Math.abs(val - median) / x;
21        }
22        return ops;
23    }
24}