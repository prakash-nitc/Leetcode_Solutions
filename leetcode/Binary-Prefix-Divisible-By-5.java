1import java.util.*;
2
3class Solution {
4    public List<Boolean> prefixesDivBy5(int[] nums) {
5        List<Boolean> ans = new ArrayList<>();
6        int curr = 0;
7
8        for (int num : nums) {
9            curr = (curr * 2 + num) % 5;
10            ans.add(curr == 0);
11        }
12
13        return ans;
14    }
15}
16