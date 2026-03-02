1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] trailingZeros = new int[n];
5
6        // Count trailing zeros for each row
7        for (int i = 0; i < n; i++) {
8            int count = 0;
9            for (int j = n - 1; j >= 0; j--) {
10                if (grid[i][j] == 0) {
11                    count++;
12                } else {
13                    break;
14                }
15            }
16            trailingZeros[i] = count;
17        }
18
19        int swaps = 0;
20
21        // For each row i, we need at least (n - 1 - i) trailing zeros
22        for (int i = 0; i < n; i++) {
23            int need = n - 1 - i;
24            int j = i;
25
26            // Find the first row j >= i that satisfies the requirement
27            while (j < n && trailingZeros[j] < need) {
28                j++;
29            }
30
31            // If none found, impossible
32            if (j == n) return -1;
33
34            // Bubble row j up to position i
35            while (j > i) {
36                int tmp = trailingZeros[j];
37                trailingZeros[j] = trailingZeros[j - 1];
38                trailingZeros[j - 1] = tmp;
39                j--;
40                swaps++;
41            }
42        }
43
44        return swaps;
45    }
46}
47