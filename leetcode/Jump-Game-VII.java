1import java.util.*;
2
3class Solution {
4    public boolean canReach(String s, int minJump, int maxJump) {
5        int n = s.length();
6        if (s.charAt(n - 1) == '1') return false;
7
8        Queue<Integer> q = new LinkedList<>();
9        q.offer(0);
10        int farthest = 0;
11
12        while (!q.isEmpty()) {
13            int i = q.poll();
14            if (i == n - 1) return true;
15
16            int start = Math.max(i + minJump, farthest + 1);
17            int end = Math.min(i + maxJump, n - 1);
18
19            for (int j = start; j <= end; j++) {
20                if (s.charAt(j) == '0') {
21                    if (j == n - 1) return true;
22                    q.offer(j);
23                }
24            }
25            farthest = end;
26        }
27
28        return false;
29    }
30}