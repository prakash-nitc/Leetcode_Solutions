1class Solution {
2    public int minFlips(String s) {
3        int n = s.length();
4        StringBuilder sb = new StringBuilder();
5        sb.append(s).append(s);
6        String t = sb.toString();
7
8        // build two alternating patterns of length 2n: 0101... and 1010...
9        char[] alt1 = new char[2 * n];
10        char[] alt2 = new char[2 * n];
11        for (int i = 0; i < 2 * n; i++) {
12            if (i % 2 == 0) {
13                alt1[i] = '0';
14                alt2[i] = '1';
15            } else {
16                alt1[i] = '1';
17                alt2[i] = '0';
18            }
19        }
20
21        int res = Integer.MAX_VALUE;
22        int diff1 = 0, diff2 = 0;
23        int left = 0;
24
25        for (int right = 0; right < 2 * n; right++) {
26            if (t.charAt(right) != alt1[right]) diff1++;
27            if (t.charAt(right) != alt2[right]) diff2++;
28
29            // maintain window size <= n
30            if (right - left + 1 > n) {
31                if (t.charAt(left) != alt1[left]) diff1--;
32                if (t.charAt(left) != alt2[left]) diff2--;
33                left++;
34            }
35
36            // when window size exactly n, update answer
37            if (right - left + 1 == n) {
38                res = Math.min(res, Math.min(diff1, diff2));
39            }
40        }
41
42        return res;
43    }
44}
45