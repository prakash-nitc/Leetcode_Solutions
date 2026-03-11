1class Solution {
2    public void reverseString(char[] s) {
3        int left = 0, right = s.length - 1;
4        while (left < right) {
5            char temp = s[left];
6            s[left] = s[right];
7            s[right] = temp;
8            left++;
9            right--;
10        }
11    }
12}
13