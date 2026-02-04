1class Solution {
2    public boolean isPalindrome(int x) {
3        // Step 1: handle base cases
4        if (x < 0 || (x % 10 == 0 && x != 0)) {
5            return false;
6        }
7
8        int reversedHalf = 0;
9
10        // Step 2: reverse half of the number
11        while (x > reversedHalf) {
12            int digit = x % 10;
13            reversedHalf = reversedHalf * 10 + digit;
14            x /= 10;
15        }
16
17        // Step 3: Check for equality (odd and even length)
18        return (x == reversedHalf || x == reversedHalf / 10);
19    }
20}
21