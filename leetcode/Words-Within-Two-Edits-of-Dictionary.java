1import java.util.*;
2
3class Solution {
4    public List<String> twoEditWords(String[] queries, String[] dictionary) {
5        List<String> ans = new ArrayList<>();
6        
7        for (String q : queries) {
8            if (canMatch(q, dictionary)) {
9                ans.add(q);
10            }
11        }
12        
13        return ans;
14    }
15    
16    private boolean canMatch(String q, String[] dictionary) {
17        for (String d : dictionary) {
18            if (diffWithinTwo(q, d)) {
19                return true;
20            }
21        }
22        return false;
23    }
24    
25    private boolean diffWithinTwo(String a, String b) {
26        int diff = 0;
27        int n = a.length();
28        
29        for (int i = 0; i < n; i++) {
30            if (a.charAt(i) != b.charAt(i)) {
31                diff++;
32                if (diff > 2) { // early stop
33                    return false;
34                }
35            }
36        }
37        return true; // differences are 0, 1, or 2
38    }
39}