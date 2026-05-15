1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
4        int dir = 0;
5        int x = 0, y = 0;
6        int maxDist = 0;
7        
8        Set<String> obstacleSet = new HashSet<>();
9        for (int[] obstacle : obstacles) {
10            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
11        }
12        
13        for (int command : commands) {
14            if (command == -2) {
15                dir = (dir + 3) % 4;
16            } else if (command == -1) {
17                dir = (dir + 1) % 4;
18            } else {
19                for (int i = 0; i < command; i++) {
20                    int nx = x + directions[dir][0];
21                    int ny = y + directions[dir][1];
22                    
23                    if (!obstacleSet.contains(nx + "," + ny)) {
24                        x = nx;
25                        y = ny;
26                        maxDist = Math.max(maxDist, x * x + y * y);
27                    } else {
28                        break;
29                    }
30                }
31            }
32        }
33        
34        return maxDist;
35    }
36}