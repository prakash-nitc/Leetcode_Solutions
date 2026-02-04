1class Solution {
2    public boolean isMatch(String s, String p) {
3        return isMatchRec(s, p, 0, 0);
4    }
5    
6    private boolean isMatchRec(String s, String p, int si, int pi) {
7        // If we reached the end of both strings, it's a match
8        if (pi == p.length())
9            return si == s.length();
10        
11        // Check if current position matches (for '.', or equal chars)
12        boolean currMatch = (si < s.length()) &&
13            (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '.');
14        
15        // If next in pattern is '*'
16        if (pi+1 < p.length() && p.charAt(pi+1) == '*') {
17            // Try using '*' as zero occurrences or more occurrences of prev element
18            return isMatchRec(s, p, si, pi+2) ||
19                   (currMatch && isMatchRec(s, p, si+1, pi));
20        } else {
21            // If no '*', move to next character in both
22            return currMatch && isMatchRec(s, p, si+1, pi+1);
23        }
24    }
25}
26