1class Solution {
2    public boolean canReach(int[] arr, int start) {
3        boolean[] visited = new boolean[arr.length];
4        return dfs(arr, start, visited);
5    }
6
7    private boolean dfs(int[] arr, int i, boolean[] visited) {
8        if (i < 0 || i >= arr.length) return false;
9        if (visited[i]) return false;
10        if (arr[i] == 0) return true;
11        visited[i] = true;
12        int forward = i + arr[i];
13        int backward = i - arr[i];
14        return dfs(arr, forward, visited) || dfs(arr, backward, visited);
15    }
16}