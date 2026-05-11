1class Solution {
2    public int[] separateDigits(int[] nums) {
3        java.util.List<Integer> list = new java.util.ArrayList<>();
4        for (int num : nums) {
5            char[] chars = String.valueOf(num).toCharArray();
6            for (char c : chars) {
7                list.add(c - '0');
8            }
9        }
10        int[] ans = new int[list.size()];
11        for (int i = 0; i < list.size(); i++) {
12            ans[i] = list.get(i);
13        }
14        return ans;
15    }
16}