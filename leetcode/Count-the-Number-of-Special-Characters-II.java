1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int n = word.length();
4        int[] lastLower = new int[26];
5        int[] firstUpper = new int[26];
6        for (int i = 0; i < 26; i++) {
7            lastLower[i] = -1;
8            firstUpper[i] = n;
9        }
10        
11        for (int i = 0; i < n; i++) {
12            char ch = word.charAt(i);
13            if (ch >= 'a' && ch <= 'z') {
14                int idx = ch - 'a';
15                lastLower[idx] = i;
16            } else {
17                int idx = ch - 'A';
18                if (firstUpper[idx] == n) {
19                    firstUpper[idx] = i;
20                }
21            }
22        }
23        
24        int count = 0;
25        for (int c = 0; c < 26; c++) {
26            if (lastLower[c] != -1 && firstUpper[c] != n && lastLower[c] < firstUpper[c]) {
27                count++;
28            }
29        }
30        return count;
31    }
32}