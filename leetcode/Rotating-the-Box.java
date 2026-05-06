1class Solution {
2    public char[][] rotateTheBox(char[][] box) {
3        int m = box.length;
4        int n = box[0].length;
5
6        for (int i = 0; i < m; i++) {
7            int emptyPos = n - 1;
8            for (int j = n - 1; j >= 0; j--) {
9                if (box[i][j] == '*') {
10                    emptyPos = j - 1;
11                } else if (box[i][j] == '#') {
12                    box[i][j] = '.';
13                    box[i][emptyPos] = '#';
14                    emptyPos--;
15                }
16            }
17        }
18
19        char[][] res = new char[n][m];
20        for (int i = 0; i < m; i++) {
21            for (int j = 0; j < n; j++) {
22                res[j][m - 1 - i] = box[i][j];
23            }
24        }
25        return res;
26    }
27}