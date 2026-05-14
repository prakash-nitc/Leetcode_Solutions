1class Solution {
2    public boolean isGood(int[] nums) {
3        int n = nums.length - 1;
4        int max = 0;
5        for (int num : nums) {
6            max = Math.max(max, num);
7        }
8        if (max != n) {
9            return false;
10        }
11        int[] freq = new int[n + 1];
12        for (int num : nums) {
13            freq[num]++;
14        }
15        for (int i = 1; i < n; i++) {
16            if (freq[i] != 1) {
17                return false;
18            }
19        }
20        return freq[n] == 2;
21    }
22}