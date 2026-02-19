1class Solution {
2    public int countBinarySubstrings(String s) {
3        int n = s.length();
4        if (n <= 1) return 0;
5
6        int prevGroupLen = 0;   // length of previous consecutive block
7        int currGroupLen = 1;   // length of current consecutive block
8        int count = 0;
9
10        for (int i = 1; i < n; i++) {
11            if (s.charAt(i) == s.charAt(i - 1)) {
12                // still in the same group
13                currGroupLen++;
14            } else {
15                // group boundary: add min(prev, curr)
16                count += Math.min(prevGroupLen, currGroupLen);
17                prevGroupLen = currGroupLen;
18                currGroupLen = 1;
19            }
20        }
21
22        // last pair of adjacent groups
23        count += Math.min(prevGroupLen, currGroupLen);
24        return count;
25    }
26}
27