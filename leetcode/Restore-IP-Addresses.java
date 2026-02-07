1class Solution {
2    public List<String> restoreIpAddresses(String s) {
3        List<String> result = new ArrayList<>();
4        backtrack(s, 0, 0, new StringBuilder(), result);
5        return result;
6    }
7
8    private void backtrack(String s, int index, int part, StringBuilder current, List<String> result) {
9        // If 4 parts are formed and all characters are used
10        if (part == 4) {
11            if (index == s.length()) {
12                result.add(current.toString());
13            }
14            return;
15        }
16
17        // Remaining characters must be enough but not too many
18        int remainingChars = s.length() - index;
19        int minNeeded = (4 - part);      // at least 1 per remaining part
20        int maxAllowed = (4 - part) * 3; // at most 3 per part
21        if (remainingChars < minNeeded || remainingChars > maxAllowed) {
22            return;
23        }
24
25        int lenBefore = current.length();
26
27        // Try 1 to 3 digits for this part
28        int num = 0;
29        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
30            // Leading zero check: if first digit is '0', this part must be exactly "0"
31            if (i > index && s.charAt(index) == '0') {
32                break;
33            }
34
35            num = num * 10 + (s.charAt(i) - '0');
36            if (num > 255) {
37                break;
38            }
39
40            if (part > 0) {
41                current.append('.');
42            }
43            current.append(s, index, i + 1);
44
45            backtrack(s, i + 1, part + 1, current, result);
46
47            current.setLength(lenBefore);
48        }
49    }
50}
51