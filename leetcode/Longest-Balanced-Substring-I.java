1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int ans = 0;
5
6        for (int i = 0; i < n; i++) {
7            int[] freq = new int[26];
8            for (int j = i; j < n; j++) {
9                freq[s.charAt(j) - 'a']++;
10
11                if (isBalanced(freq)) {
12                    ans = Math.max(ans, j - i + 1);
13                }
14            }
15        }
16
17        return ans;
18    }
19
20    private boolean isBalanced(int[] freq) {
21        int common = 0;
22        for (int f : freq) {
23            if (f == 0) continue;
24            if (common == 0) {
25                common = f;
26            } else if (f != common) {
27                return false;
28            }
29        }
30        return common != 0;
31    }
32}
33