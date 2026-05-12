1import java.util.*;
2
3class Solution {
4    public int minimumEffort(int[][] tasks) {
5        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
6        int energy = 0;
7        for (int[] task : tasks) {
8            int actual = task[0];
9            int minimum = task[1];
10            if (energy < minimum) {
11                energy = minimum;
12            }
13            energy -= actual;
14        }
15        return energy + Arrays.stream(tasks).mapToInt(t -> t[0]).sum();
16    }
17}