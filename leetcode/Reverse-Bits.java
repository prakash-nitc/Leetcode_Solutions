1class Solution {
2    public int reverseBits(int n) {
3        int result = 0;
4        // Process each bit individually
5        for (int i = 0; i < 32; i++) {
6            result <<= 1;           // Shift result left to make space for next bit
7            result |= (n & 1);      // Add the least significant bit of n
8            n >>= 1;                // Shift n right to process the next bit
9        }
10        return result;
11    }
12}
13