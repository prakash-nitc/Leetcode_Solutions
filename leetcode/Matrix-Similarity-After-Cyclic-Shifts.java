1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length;
4        int n = mat[0].length;
5        
6        // Effective shifts modulo row length
7        k %= n;
8        if (k == 0) return true;  // after full cycles, matrix is same
9        
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                int nj;
13                if (i % 2 == 0) {
14                    // even row: left shift
15                    nj = (j + k) % n;
16                } else {
17                    // odd row: right shift
18                    nj = (j - k) % n;
19                    if (nj < 0) nj += n;
20                }
21                if (mat[i][j] != mat[i][nj]) {
22                    return false;
23                }
24            }
25        }
26        return true;
27    }
28}