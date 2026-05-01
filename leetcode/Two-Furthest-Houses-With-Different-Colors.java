1class Solution {
2    public int maxDistance(int[] colors) {
3        int n = colors.length;
4        if (colors[0] != colors[n - 1]) {
5            return n - 1;
6        }
7
8        int i = 0;
9        while (i < n && colors[i] == colors[n - 1]) {
10            i++;
11        }
12
13        int j = n - 1;
14        while (j >= 0 && colors[j] == colors[0]) {
15            j--;
16        }
17
18        return Math.max(n - 1 - i, j);
19    }
20}