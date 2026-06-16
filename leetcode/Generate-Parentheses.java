1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> result = new ArrayList<>();
4        backtrack(result, "", n, n);
5        return result;
6    }
7
8    private void backtrack(List<String> result, String current, int open, int close) {
9        // Base case: Valid complete combination
10        if (open == 0 && close == 0) {
11            result.add(current);
12            return;
13        }
14        // Try to place '(' if any left
15        if (open > 0) {
16            backtrack(result, current + "(", open - 1, close);
17        }
18        // Try to place ')' if more closes than opens left
19        if (close > open) {
20            backtrack(result, current + ")", open, close - 1);
21        }
22    }
23}
24