1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int total = n * m;
6        int MOD = 12345;
7
8        int[][] ans = new int[n][m];
9
10        // Suffix products over flattened index
11        int suf = 1;
12        for (int k = total - 1; k >= 0; k--) {
13            int i = k / m;
14            int j = k % m;
15            ans[i][j] = suf;                     // store suffix product for this cell
16            suf = (int)((long)suf * (grid[i][j] % MOD) % MOD);
17        }
18
19        // Prefix products and combine with suffix
20        int pre = 1;
21        for (int k = 0; k < total; k++) {
22            int i = k / m;
23            int j = k % m;
24            ans[i][j] = (int)((long)ans[i][j] * pre % MOD);  // prefix * suffix
25            pre = (int)((long)pre * (grid[i][j] % MOD) % MOD);
26        }
27
28        return ans;
29    }
30}