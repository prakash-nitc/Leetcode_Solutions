1class Solution {
2    public String longestPalindrome(String s) {
3        int n = s.length();
4        if (n < 2) return s;
5        int start = 0, maxLen = 1;
6        
7        for (int i = 0; i < n;) {
8            if (n - i <= maxLen / 2) break;
9            int left = i, right = i;
10            while (right < n - 1 && s.charAt(right) == s.charAt(right + 1)) right++;
11            i = right + 1;
12            while (left > 0 && right < n - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
13                left--;
14                right++;
15            }
16            int len = right - left + 1;
17            if (len > maxLen) {
18                start = left;
19                maxLen = len;
20            }
21        }
22        return s.substring(start, start + maxLen);
23    }
24}
25