1class Solution {
2    public int numSteps(String s) {
3        int steps = 0;
4        int carry = 0;
5
6        // Process from least significant bit (right) to left,
7        // but stop before the most significant bit (index 0).
8        for (int i = s.length() - 1; i > 0; i--) {
9            int bit = s.charAt(i) - '0';
10
11            // Effective bit after including carry.
12            int cur = bit + carry;
13
14            if (cur == 0) {
15                // Even: just divide by 2 (one step).
16                steps += 1;
17                // carry stays 0
18            } else if (cur == 1) {
19                // Odd: +1 makes it even, then /2
20                // So two steps: +1 and /2, and introduces carry = 1.
21                steps += 2;
22                carry = 1;
23            } else { // cur == 2
24                // Bit is effectively 0 with a carry (2 in decimal),
25                // so it's even: only /2 (one step), carry remains 1.
26                steps += 1;
27                // carry remains 1
28            }
29        }
30
31        // If there's still a carry at the most significant bit,
32        // it contributes one extra step.
33        return steps + carry;
34    }
35}
36