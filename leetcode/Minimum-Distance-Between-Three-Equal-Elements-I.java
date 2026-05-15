1class Solution {
2    public int minimumDistance(int[] nums) {
3        int n = nums.length;
4        int minDistance = Integer.MAX_VALUE;
5        
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                for (int k = j + 1; k < n; k++) {
9                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
10                        int distance = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
11                        minDistance = Math.min(minDistance, distance);
12                    }
13                }
14            }
15        }
16        
17        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
18    }
19}