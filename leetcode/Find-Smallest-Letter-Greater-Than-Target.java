1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int n = letters.length;
4        int left = 0, right = n - 1;
5        
6        // Standard binary search to find first char > target
7        while (left <= right) {
8            int mid = left + (right - left) / 2;
9            if (letters[mid] <= target) {
10                left = mid + 1;
11            } else {
12                right = mid - 1;
13            }
14        }
15        
16        // If left is out of bounds, wrap around to 0
17        return letters[left % n];
18    }
19}
20