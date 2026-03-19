1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        // prefix[i][j][0] = count of 'X' in rectangle (0,0)..(i-1,j-1)
7        // prefix[i][j][1] = count of 'Y' in rectangle (0,0)..(i-1,j-1)
8        int[][][] prefix = new int[m + 1][n + 1][2];
9
10        int ans = 0;
11
12        for (int i = 1; i <= m; i++) {
13            for (int j = 1; j <= n; j++) {
14                // copy previous counts using inclusion–exclusion
15                prefix[i][j][0] = prefix[i - 1][j][0]
16                        + prefix[i][j - 1][0]
17                        - prefix[i - 1][j - 1][0]
18                        + (grid[i - 1][j - 1] == 'X' ? 1 : 0);
19
20                prefix[i][j][1] = prefix[i - 1][j][1]
21                        + prefix[i][j - 1][1]
22                        - prefix[i - 1][j - 1][1]
23                        + (grid[i - 1][j - 1] == 'Y' ? 1 : 0);
24
25                // submatrix is fixed to start at (0,0) and end at (i-1,j-1)
26                int cntX = prefix[i][j][0];
27                int cntY = prefix[i][j][1];
28
29                if (cntX > 0 && cntX == cntY) {
30                    ans++;
31                }
32            }
33        }
34
35        return ans;
36    }
37}
38