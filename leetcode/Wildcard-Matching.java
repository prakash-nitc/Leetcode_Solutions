1class Solution {
2    public boolean isMatch(String s, String p) {
3        int i = 0, j = 0;
4        int starIdx = -1, match = 0;
5        int n = s.length(), m = p.length();
6
7        while (i < n) {
8            if (j < m && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
9                i++;
10                j++;
11            } else if (j < m && p.charAt(j) == '*') {
12                starIdx = j;
13                match = i;
14                j++;
15            } else if (starIdx != -1) {
16                j = starIdx + 1;
17                match++;
18                i = match;
19            } else {
20                return false;
21            }
22        }
23
24        while (j < m && p.charAt(j) == '*') {
25            j++;
26        }
27
28        return j == m;
29    }
30}