1class Solution {
2    public int subarraySum(int[] nums, int k) {
3
4        HashMap<Integer, Integer> map = new HashMap<>();
5
6        // Prefix sum 0 has occurred once
7        map.put(0, 1);
8
9        int sum = 0;
10        int count = 0;
11
12        for (int i = 0; i < nums.length; i++) {
13
14            sum += nums[i];
15
16            // Check if (sum - k) has been seen before
17            if (map.containsKey(sum - k)) {
18                count += map.get(sum - k);
19            }
20            // Store/update current prefix sum
21            map.put(sum, map.getOrDefault(sum, 0) + 1);
22        }
23
24        return count;
25    }
26}