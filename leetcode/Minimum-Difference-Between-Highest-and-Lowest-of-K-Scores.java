1import java.util.Arrays;
2
3class Solution {
4    public int minimumDifference(int[] nums, int k) {
5        if (k == 1) return 0;                // any one element => diff = 0 [web:6]
6        
7        Arrays.sort(nums);                   // sort scores ascending [web:6]
8        int n = nums.length;
9        int ans = Integer.MAX_VALUE;
10
11        // window [i, i + k - 1]
12        for (int i = 0; i + k - 1 < n; i++) {
13            int diff = nums[i + k - 1] - nums[i];
14            ans = Math.min(ans, diff);       // track minimum range [web:6]
15        }
16
17        return ans;
18    }
19}
20