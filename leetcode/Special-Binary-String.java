1class Solution {
2    public String makeLargestSpecial(String s) {
3        int n = s.length();
4        if (n <= 2) return s;
5
6        List<String> parts = new ArrayList<>();
7        int count = 0;
8        int start = 0;
9
10        // Split into primitive special substrings
11        for (int i = 0; i < n; i++) {
12            if (s.charAt(i) == '1') count++;
13            else count--;
14
15            // When count == 0, we found a special substring s[start..i]
16            if (count == 0) {
17                // inner part is s[start+1 .. i-1]
18                String inner = s.substring(start + 1, i);
19                // recursively make the inner part largest, then wrap with 1 and 0
20                String made = "1" + makeLargestSpecial(inner) + "0";
21                parts.add(made);
22                start = i + 1;
23            }
24        }
25
26        // Sort in descending lexicographical order
27        Collections.sort(parts, Collections.reverseOrder());
28
29        // Concatenate all parts
30        StringBuilder sb = new StringBuilder();
31        for (String str : parts) sb.append(str);
32        return sb.toString();
33    }
34}
35