1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        int prev = -1; // previous bit (start with invalid)
4        while (n != 0) {
5            int curr = n & 1;   // current least-significant bit
6            if (curr == prev) { // same as previous -> not alternating
7                return false;
8            }
9            prev = curr;
10            n >>= 1;            // move to next bit
11        }
12        return true;
13    }
14}
15