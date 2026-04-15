1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n = words.length;
4        int ans = n;
5
6        for (int i = 0; i < n; i++) {
7            if (words[i].equals(target)) {
8                int direct = Math.abs(i - startIndex);
9                int wrap = n - direct;
10                ans = Math.min(ans, Math.min(direct, wrap));
11            }
12        }
13
14        return ans == n ? -1 : ans;
15    }
16}