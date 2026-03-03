1class Solution {
2    public int[] sortedSquares(int[] nums) {
3
4        int n = nums.length;
5        int[] result = new int[n];
6
7        int left = 0;
8        int right = n - 1;
9        int pos = n - 1;   // Fill from the end (largest squares first)
10
11        // Continue until pointers cross
12        while (left <= right) {
13
14            int leftSquare = nums[left] * nums[left];
15            int rightSquare = nums[right] * nums[right];
16
17            if (leftSquare > rightSquare) {
18                result[pos] = leftSquare;
19                left++; 
20                pos--;         // Move left pointer forward
21            } else {
22                result[pos] = rightSquare;
23                right--; 
24                pos--;        // Move right pointer backward
25            }
26
27                       // Move fill position backward
28        }
29
30        return result;
31    }
32}