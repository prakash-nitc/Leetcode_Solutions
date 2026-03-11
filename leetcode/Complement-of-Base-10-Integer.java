1class Solution {
2    public int bitwiseComplement(int n) {
3        // Edge case: complement of 0 is 1
4        if (n == 0) {
5            return 1;
6        }
7
8        // Build a mask with all bits = 1 up to the highest set bit of n
9        int mask = 0;
10        int temp = n;
11        while (temp > 0) {
12            mask = (mask << 1) | 1; // append 1 bit
13            temp >>= 1;            // move to next bit
14        }
15
16        // XOR with mask flips all bits of n within that range
17        return n ^ mask;
18    }
19}
20