1class Solution {
2    public String getHappyString(int n, int k) {
3        List<String> list = new ArrayList<>();
4        backtrack(n, k, new StringBuilder(), list);
5        if (list.size() < k) return "";
6        return list.get(k - 1);
7    }
8
9    private void backtrack(int n, int k, StringBuilder sb, List<String> list) {
10        if (sb.length() == n) {
11            list.add(sb.toString());
12            return;
13        }
14
15        // Early stop if we already have k strings
16        if (list.size() >= k) return;
17
18        for (char c : new char[]{'a', 'b', 'c'}) {
19            int len = sb.length();
20            if (len > 0 && sb.charAt(len - 1) == c) continue; // must be different from previous
21
22            sb.append(c);
23            backtrack(n, k, sb, list);
24            sb.deleteCharAt(sb.length() - 1);
25
26            // Again, early stop to avoid unnecessary work
27            if (list.size() >= k) return;
28        }
29    }
30}
31