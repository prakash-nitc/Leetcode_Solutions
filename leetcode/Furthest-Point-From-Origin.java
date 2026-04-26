1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int left = 0, right = 0, blank = 0;
4
5        for (int i = 0; i < moves.length(); i++) {
6            char c = moves.charAt(i);
7            if (c == 'L') left++;
8            else if (c == 'R') right++;
9            else blank++; // '_'
10        }
11
12        // Net displacement from fixed moves is |left - right|
13        // All blanks can be used to go further in the same direction
14        return Math.abs(left - right) + blank;
15    }
16}