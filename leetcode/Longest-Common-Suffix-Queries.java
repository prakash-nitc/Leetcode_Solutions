1class Solution {
2    static class Node {
3        int idx = -1;
4        Node[] next = new Node[26];
5    }
6
7    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
8        Node root = new Node();
9        int n = wordsContainer.length;
10        int bestGlobal = 0;
11        for (int i = 1; i < n; i++) {
12            if (wordsContainer[i].length() < wordsContainer[bestGlobal].length()) {
13                bestGlobal = i;
14            }
15        }
16        root.idx = bestGlobal;
17
18        for (int i = 0; i < n; i++) {
19            String w = wordsContainer[i];
20            int len = w.length();
21            Node cur = root;
22            update(cur, i, wordsContainer);
23            for (int j = len - 1; j >= 0; j--) {
24                int c = w.charAt(j) - 'a';
25                if (cur.next[c] == null) cur.next[c] = new Node();
26                cur = cur.next[c];
27                update(cur, i, wordsContainer);
28            }
29        }
30
31        int m = wordsQuery.length;
32        int[] ans = new int[m];
33        for (int i = 0; i < m; i++) {
34            String q = wordsQuery[i];
35            Node cur = root;
36            int best = cur.idx;
37            for (int j = q.length() - 1; j >= 0; j--) {
38                int c = q.charAt(j) - 'a';
39                if (cur.next[c] == null) break;
40                cur = cur.next[c];
41                best = cur.idx;
42            }
43            ans[i] = best;
44        }
45        return ans;
46    }
47
48    private void update(Node node, int cand, String[] words) {
49        if (node.idx == -1) {
50            node.idx = cand;
51            return;
52        }
53        String a = words[cand];
54        String b = words[node.idx];
55        if (a.length() < b.length()) {
56            node.idx = cand;
57        } else if (a.length() == b.length() && cand < node.idx) {
58            node.idx = cand;
59        }
60    }
61}