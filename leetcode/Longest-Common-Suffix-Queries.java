1class Solution {
2    static class Node {
3        Node[] next = new Node[26];
4        int best = -1;
5    }
6
7    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
8        Node root = new Node();
9        int n = wordsContainer.length;
10        int globalBest = 0;
11
12        for (int i = 1; i < n; i++) {
13            if (wordsContainer[i].length() < wordsContainer[globalBest].length()) {
14                globalBest = i;
15            }
16        }
17        root.best = globalBest;
18
19        for (int i = 0; i < n; i++) {
20            String w = wordsContainer[i];
21            Node cur = root;
22            update(cur, i, wordsContainer);
23            for (int j = w.length() - 1; j >= 0; j--) {
24                int c = w.charAt(j) - 'a';
25                if (cur.next[c] == null) cur.next[c] = new Node();
26                cur = cur.next[c];
27                update(cur, i, wordsContainer);
28            }
29        }
30
31        int[] ans = new int[wordsQuery.length];
32        for (int qi = 0; qi < wordsQuery.length; qi++) {
33            String q = wordsQuery[qi];
34            Node cur = root;
35            int best = cur.best;
36            for (int j = q.length() - 1; j >= 0; j--) {
37                int c = q.charAt(j) - 'a';
38                if (cur.next[c] == null) break;
39                cur = cur.next[c];
40                best = cur.best;
41            }
42            ans[qi] = best;
43        }
44        return ans;
45    }
46
47    private void update(Node node, int idx, String[] words) {
48        if (node.best == -1) {
49            node.best = idx;
50            return;
51        }
52        int a = idx;
53        int b = node.best;
54        if (words[a].length() < words[b].length() || (words[a].length() == words[b].length() && a < b)) {
55            node.best = a;
56        }
57    }
58}