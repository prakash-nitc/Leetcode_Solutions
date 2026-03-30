1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] even = new int[26];
4        int[] odd  = new int[26];
5
6        for (int i = 0; i < s1.length(); i++) {
7            if (i % 2 == 0) {
8                even[s1.charAt(i) - 'a']++;
9                even[s2.charAt(i) - 'a']--;
10            } else {
11                odd[s1.charAt(i) - 'a']++;
12                odd[s2.charAt(i) - 'a']--;
13            }
14        }
15
16        for (int i = 0; i < 26; i++) {
17            if (even[i] != 0 || odd[i] != 0) return false;
18        }
19        return true;
20    }
21}