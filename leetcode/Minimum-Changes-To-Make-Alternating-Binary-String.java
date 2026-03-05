1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        int countStartWith0 = 0; // pattern "0101..."
5        int countStartWith1 = 0; // pattern "1010..."
6
7        for (int i = 0; i < n; i++) {
8            char c = s.charAt(i);
9
10            // expected for pattern starting with '0'
11            char expected0 = (i % 2 == 0) ? '0' : '1';
12            if (c != expected0) {
13                countStartWith0++;
14            }
15
16            // expected for pattern starting with '1'
17            char expected1 = (i % 2 == 0) ? '1' : '0';
18            if (c != expected1) {
19                countStartWith1++;
20            }
21        }
22
23        return Math.min(countStartWith0, countStartWith1);
24    }
25}
26