1class Solution {
2    public int search(int[] nums, int target) {
3        int low = 0, high = nums.length - 1;
4
5        while (low <= high) {
6            int mid = low + (high - low) / 2;
7
8            if (nums[mid] == target) return mid;
9
10            if (nums[low] <= nums[mid]) {
11                if (target >= nums[low] && target < nums[mid]) {
12                    high = mid - 1;
13                } else {
14                    low = mid + 1;
15                }
16            } else {
17                if (target > nums[mid] && target <= nums[high]) {
18                    low = mid + 1;
19                } else {
20                    high = mid - 1;
21                }
22            }
23        }
24
25        return -1;
26    }
27}