1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> subsetsWithDup(int[] nums) {
7        List<List<Integer>> res = new ArrayList<>();
8        Arrays.sort(nums);  // sort so duplicates are adjacent
9        backtrack(nums, 0, new ArrayList<>(), res);
10        return res;
11    }
12
13    private void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> res) {
14        res.add(new ArrayList<>(curr));
15
16        for (int i = start; i < nums.length; i++) {
17            // skip duplicates at the same recursion level
18            if (i > start && nums[i] == nums[i - 1]) continue;
19
20            curr.add(nums[i]);
21            backtrack(nums, i + 1, curr, res);
22            curr.remove(curr.size() - 1);
23        }
24    }
25}
26