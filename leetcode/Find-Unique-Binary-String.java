1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        int n = nums.length;
4        StringBuilder sb = new StringBuilder();
5
6        // For each i, take nums[i][i] and flip it.
7        for (int i = 0; i < n; i++) {
8            char c = nums[i].charAt(i);
9            sb.append(c == '0' ? '1' : '0');
10        }
11
12        return sb.toString();
13    }
14}
15