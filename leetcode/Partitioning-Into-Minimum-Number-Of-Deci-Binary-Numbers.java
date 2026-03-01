1class Solution {
2    public int minPartitions(String n) {
3        int maxDigit = 0;
4        for (int i = 0; i < n.length(); i++) {
5            int d = n.charAt(i) - '0';
6            if (d > maxDigit) {
7                maxDigit = d;
8                if (maxDigit == 9) { // early exit, can't get higher
9                    break;
10                }
11            }
12        }
13        return maxDigit;
14    }
15}
16