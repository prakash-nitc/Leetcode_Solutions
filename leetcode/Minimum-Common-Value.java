1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int i = 0, j = 0;
4        while (i < nums1.length && j < nums2.length) {
5            if (nums1[i] == nums2[j]) return nums1[i];
6            if (nums1[i] < nums2[j]) i++;
7            else j++;
8        }
9        return -1;
10    }
11}