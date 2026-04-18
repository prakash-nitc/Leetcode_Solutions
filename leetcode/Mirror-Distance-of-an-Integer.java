1class Solution {
2    public int mirrorDistance(int n) {
3        int rev = reverse(n);
4        return Math.abs(n - rev);
5    }
6
7    private int reverse(int x) {
8        int res = 0;
9        while (x > 0) {
10            int digit = x % 10;
11            res = res * 10 + digit;
12            x /= 10;
13        }
14        return res;
15    }
16}