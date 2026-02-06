1import java.util.Arrays;
2
3class Solution {
4    public int minRemoval(int[] nums, int k) {
5        int n = nums.length;
6        Arrays.sort(nums);
7        
8        int maxLen = 1;  // at least one element is always balanced
9        int left = 0;
10
11        for (int right = 0; right < n; right++) {
12            // While current window [left, right] is not balanced, move left
13            while ((long) nums[right] > (long) k * nums[left]) {
14                left++;
15            }
16            // Now [left, right] is balanced; update maxLen
17            maxLen = Math.max(maxLen, right - left + 1);
18        }
19        
20        // Minimum removals = remove everything outside the largest balanced window
21        return n - maxLen;
22    }
23}
24