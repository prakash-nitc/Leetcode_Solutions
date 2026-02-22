1class Solution {
2    public int binaryGap(int n) {
3        int lastOne = -1;   // position of previous 1 bit
4        int maxGap = 0;     // answer
5        int index = 0;      // current bit position (0-based from LSB)
6
7        while (n > 0) {
8            if ((n & 1) == 1) {      // if current bit is 1
9                if (lastOne != -1) { // if we have seen a 1 before
10                    maxGap = Math.max(maxGap, index - lastOne);
11                }
12                lastOne = index;     // update last seen 1 position
13            }
14            n >>= 1;   // shift right to check next bit
15            index++;   // move to next bit position
16        }
17
18        return maxGap;
19    }
20}
21