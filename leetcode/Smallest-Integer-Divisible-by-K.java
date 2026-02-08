1class Solution {
2    public int smallestRepunitDivByK(int k) {
3        // If k has factor 2 or 5, no number of all 1's can be divisible by k
4        if (k % 2 == 0 || k % 5 == 0) return -1;
5
6        int rem = 0;
7        // At most k different remainders; if none is 0 within k steps, it will loop
8        for (int len = 1; len <= k; len++) {
9            rem = (rem * 10 + 1) % k;
10            if (rem == 0) return len;
11        }
12        return -1;
13    }
14}
15