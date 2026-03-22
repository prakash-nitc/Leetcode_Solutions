1class Solution {
2    public boolean findRotation(int[][] mat, int[][] target) {
3        int n = mat.length;
4
5        // Try all 4 rotations: 0°, 90°, 180°, 270°
6        for (int k = 0; k < 4; k++) {
7            if (isEqual(mat, target)) {
8                return true;
9            }
10            rotate(mat); // rotate mat 90° clockwise for next check
11        }
12        return false;
13    }
14
15    // Rotate matrix 90 degrees clockwise in-place
16    private void rotate(int[][] matrix) {
17        int n = matrix.length;
18
19        // Transpose
20        for (int i = 0; i < n; i++) {
21            for (int j = i + 1; j < n; j++) {
22                int tmp = matrix[i][j];
23                matrix[i][j] = matrix[j][i];
24                matrix[j][i] = tmp;
25            }
26        }
27
28        // Reverse each row
29        for (int i = 0; i < n; i++) {
30            int left = 0, right = n - 1;
31            while (left < right) {
32                int tmp = matrix[i][left];
33                matrix[i][left] = matrix[i][right];
34                matrix[i][right] = tmp;
35                left++;
36                right--;
37            }
38        }
39    }
40
41    // Check if two matrices are identical
42    private boolean isEqual(int[][] a, int[][] b) {
43        int n = a.length;
44        for (int i = 0; i < n; i++) {
45            int m = a[i].length;
46            for (int j = 0; j < m; j++) {
47                if (a[i][j] != b[i][j]) {
48                    return false;
49                }
50            }
51        }
52        return true;
53    }
54}
55