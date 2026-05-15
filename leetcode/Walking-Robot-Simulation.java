1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        int[] dx = {0, 1, 0, -1};
4        int[] dy = {1, 0, -1, 0};
5        int dir = 0;
6        int x = 0, y = 0;
7        int maxDist = 0;
8        
9        Set<Long> obstacleSet = new HashSet<>();
10        for (int[] obstacle : obstacles) {
11            long hash = ((long)obstacle[0] + 30000) * 60001 + (obstacle[1] + 30000);
12            obstacleSet.add(hash);
13        }
14        
15        for (int command : commands) {
16            if (command == -2) {
17                dir = (dir + 3) % 4;
18            } else if (command == -1) {
19                dir = (dir + 1) % 4;
20            } else {
21                for (int i = 0; i < command; i++) {
22                    int nx = x + dx[dir];
23                    int ny = y + dy[dir];
24                    long hash = ((long)nx + 30000) * 60001 + (ny + 30000);
25                    
26                    if (!obstacleSet.contains(hash)) {
27                        x = nx;
28                        y = ny;
29                        maxDist = Math.max(maxDist, x * x + y * y);
30                    } else {
31                        break;
32                    }
33                }
34            }
35        }
36        
37        return maxDist;
38    }
39}