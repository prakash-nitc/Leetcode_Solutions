1class Solution {
2    public int minimumDeletions(String s) {
3        int deletions = 0;
4        int countB = 0;   // number of 'b' seen so far
5
6        for (char c : s.toCharArray()) {
7            if (c == 'b') {
8                countB++;  // keep this 'b' for now
9            } else { // c == 'a'
10                // Option 1: delete this 'a'  -> deletions + 1
11                // Option 2: delete one previous 'b' -> countB
12                // take minimum of both options
13                deletions = Math.min(deletions + 1, countB);
14            }
15        }
16
17        return deletions;
18    }
19}
20