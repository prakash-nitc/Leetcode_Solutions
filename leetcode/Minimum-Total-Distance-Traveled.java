1import java.util.*;
2
3class Solution {
4    private long[][] memo;
5    private List<Integer> robots;
6    private int[][] factories;
7    private static final long INF = (long) 1e18;
8
9    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
10        Collections.sort(robot);
11        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
12
13        this.robots = robot;
14        this.factories = factory;
15        int n = robot.size();
16        int m = factory.length;
17
18        memo = new long[n][m];
19        for (int i = 0; i < n; i++) {
20            Arrays.fill(memo[i], -1);
21        }
22
23        return dfs(0, 0);
24    }
25
26    private long dfs(int i, int j) {
27        if (i == robots.size()) return 0;
28        if (j == factories.length) return INF;
29
30        if (memo[i][j] != -1) return memo[i][j];
31
32        long ans = dfs(i, j + 1); // skip current factory
33
34        long dist = 0;
35        int pos = factories[j][0];
36        int limit = factories[j][1];
37
38        for (int k = 0; k < limit && i + k < robots.size(); k++) {
39            dist += Math.abs((long) robots.get(i + k) - pos);
40            ans = Math.min(ans, dist + dfs(i + k + 1, j + 1));
41        }
42
43        return memo[i][j] = ans;
44    }
45}