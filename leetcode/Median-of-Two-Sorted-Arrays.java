1class Solution {
2    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
3        int m = nums1.length, n = nums2.length;
4        if (m > n) {
5            // Always binary search the smaller array
6            int[] temp = nums1; nums1 = nums2; nums2 = temp;
7            int tmp = m; m = n; n = tmp;
8        }
9        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
10        while (imin <= imax) {
11            int i = (imin + imax) / 2;
12            int j = halfLen - i;
13            if (i < m && nums2[j - 1] > nums1[i]) {
14                imin = i + 1;
15            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
16                imax = i - 1;
17            } else {
18                int maxLeft;
19                if (i == 0) { maxLeft = nums2[j - 1]; }
20                else if (j == 0) { maxLeft = nums1[i - 1]; }
21                else { maxLeft = Math.max(nums1[i - 1], nums2[j - 1]); }
22                
23                if ((m + n) % 2 == 1)
24                    return maxLeft;
25                
26                int minRight;
27                if (i == m) { minRight = nums2[j]; }
28                else if (j == n) { minRight = nums1[i]; }
29                else { minRight = Math.min(nums1[i], nums2[j]); }
30                
31                return (maxLeft + minRight) / 2.0;
32            }
33        }
34        return 0.0; // input constraints guarantee this won't happen
35    }
36}
37