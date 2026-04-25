1import java.util.*;
2
3public class Solution {
4    private static class Sequence {
5        int startX, startY;
6        int endX, endY;
7        int length;
8
9        Sequence(int sx, int sy, int ex, int ey, int len) {
10            this.startX = sx;
11            this.startY = sy;
12            this.endX = ex;
13            this.endY = ey;
14            this.length = len;
15        }
16    }
17
18    public int maxDistance(int side, int[][] points, int k) {
19        List<int[]> ordered = getOrderedPoints(side, points);
20
21        int left = 0, right = side; // distance is in [0, side]
22        while (left < right) {
23            int mid = (left + right + 1) / 2;
24            if (isValid(ordered, k, mid)) {
25                left = mid;
26            } else {
27                right = mid - 1;
28            }
29        }
30        return left;
31    }
32
33    // Check if we can pick k points with min Manhattan distance >= m
34    private boolean isValid(List<int[]> ordered, int k, int m) {
35        Deque<Sequence> dq = new ArrayDeque<>();
36        int[] first = ordered.get(0);
37        dq.addLast(new Sequence(first[0], first[1], first[0], first[1], 1));
38        int maxLen = 1;
39
40        for (int i = 1; i < ordered.size(); ++i) {
41            int x = ordered.get(i)[0];
42            int y = ordered.get(i)[1];
43
44            int startX = x, startY = y;
45            int bestLen = 1;
46
47            // Maintain sequences whose end is at distance >= m from current point
48            while (!dq.isEmpty()
49                    && manhattan(x, y, dq.peekFirst().endX, dq.peekFirst().endY) >= m) {
50
51                Sequence seq = dq.peekFirst();
52
53                // If whole sequence from seq.start to current point is valid
54                if (manhattan(x, y, seq.startX, seq.startY) >= m
55                        && seq.length + 1 >= bestLen) {
56                    startX = seq.startX;
57                    startY = seq.startY;
58                    bestLen = seq.length + 1;
59                    maxLen = Math.max(maxLen, bestLen);
60                }
61
62                dq.pollFirst();
63            }
64
65            dq.addLast(new Sequence(startX, startY, x, y, bestLen));
66        }
67
68        return maxLen >= k;
69    }
70
71    private int manhattan(int x1, int y1, int x2, int y2) {
72        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
73    }
74
75    // Order boundary points: left (bottom→top), top (left→right),
76    // right (top→bottom), bottom (right→left).
77    private List<int[]> getOrderedPoints(int side, int[][] points) {
78        List<int[]> left = new ArrayList<>();
79        List<int[]> top = new ArrayList<>();
80        List<int[]> right = new ArrayList<>();
81        List<int[]> bottom = new ArrayList<>();
82
83        for (int[] p : points) {
84            int x = p[0], y = p[1];
85            if (x == 0 && y > 0) {
86                left.add(p);
87            } else if (y == side && x > 0) {
88                top.add(p);
89            } else if (x == side && y < side) {
90                right.add(p);
91            } else if (y == 0) { // includes (0,0) and (side,0)
92                bottom.add(p);
93            }
94        }
95
96        // left: y increasing
97        left.sort(Comparator.comparingInt(a -> a[1]));
98        // top: x increasing
99        top.sort(Comparator.comparingInt(a -> a[0]));
100        // right: y decreasing
101        right.sort((a, b) -> Integer.compare(b[1], a[1]));
102        // bottom: x decreasing
103        bottom.sort((a, b) -> Integer.compare(b[0], a[0]));
104
105        List<int[]> ordered = new ArrayList<>(points.length);
106        ordered.addAll(left);
107        ordered.addAll(top);
108        ordered.addAll(right);
109        ordered.addAll(bottom);
110        return ordered;
111    }
112}