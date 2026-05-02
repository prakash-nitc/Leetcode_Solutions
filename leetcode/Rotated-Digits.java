1class Solution {
2    public int rotatedDigits(int n) {
3        int count = 0;
4        for (int i = 1; i <= n; i++) {
5            if (isGood(i)) count++;
6        }
7        return count;
8    }
9
10    private boolean isGood(int x) {
11        boolean diff = false;
12        while (x > 0) {
13            int d = x % 10;
14            if (d == 3 || d == 4 || d == 7) return false;
15            if (d == 2 || d == 5 || d == 6 || d == 9) diff = true;
16            x /= 10;
17        }
18        return diff;
19    }
20}