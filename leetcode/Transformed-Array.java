1class Solution {
2    public int[] constructTransformedArray(int[] nums) {
3        int n = nums.length;
4        int[] result = new int[n];
5
6        for (int i = 0; i < n; i++) {
7            int steps = nums[i];
8            if (steps == 0) {
9                result[i] = 0;            // or nums[i]
10            } else {
11                // move right for positive, left for negative (same as adding steps)
12                int newIndex = (i + steps) % n;
13                if (newIndex < 0) {
14                    newIndex += n;        // fix negative modulo
15                }
16                result[i] = nums[newIndex];
17            }
18        }
19
20        return result;
21    }
22}
23