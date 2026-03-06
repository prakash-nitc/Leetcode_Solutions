1class Solution {
2    public boolean checkOnesSegment(String s) {
3        // We need to ensure there is no "01" followed by a '1' later,
4        // which is equivalent to checking that "01" appears at most once,
5        // and only as the transition from ones to zeros.
6        // Simpler: once we see a '0' after some '1's, we should never see '1' again.
7        boolean seenZeroAfterOne = false;
8        
9        for (int i = 0; i < s.length(); i++) {
10            char c = s.charAt(i);
11            if (c == '0') {
12                seenZeroAfterOne = true;      // we're in the zero segment now
13            } else { // c == '1'
14                if (seenZeroAfterOne) {
15                    // we already transitioned to zeros, so another '1' means a new segment
16                    return false;
17                }
18            }
19        }
20        
21        return true;
22    }
23}
24