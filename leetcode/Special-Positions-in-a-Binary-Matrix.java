1class Solution {
2    public int numSpecial(int[][] mat) {
3        int m = mat.length;
4        int n = mat[0].length;
5
6        int[] rowOnes = new int[m];
7        int[] colOnes = new int[n];
8
9        // First pass: count 1s in each row and column
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (mat[i][j] == 1) {
13                    rowOnes[i]++;
14                    colOnes[j]++;
15                }
16            }
17        }
18
19        int ans = 0;
20
21        // Second pass: a position is special if it's 1 and
22        // its row and column each have exactly one 1
23        for (int i = 0; i < m; i++) {
24            for (int j = 0; j < n; j++) {
25                if (mat[i][j] == 1 && rowOnes[i] == 1 && colOnes[j] == 1) {
26                    ans++;
27                }
28            }
29        }
30
31        return ans;
32    }
33}
34