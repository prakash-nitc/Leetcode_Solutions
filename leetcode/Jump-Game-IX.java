1import java.util.*;
2
3class Solution {
4    static class Component {
5        int value;
6        int left;
7        int right;
8        Component(int value, int left, int right) {
9            this.value = value;
10            this.left = left;
11            this.right = right;
12        }
13    }
14
15    public int[] maxValue(int[] nums) {
16        int n = nums.length;
17        int[] ans = new int[n];
18        List<Component> stack = new ArrayList<>();
19
20        for (int i = 0; i < n; i++) {
21            Component curr = new Component(nums[i], i, i);
22            while (!stack.isEmpty() && stack.get(stack.size() - 1).value > nums[i]) {
23                Component top = stack.remove(stack.size() - 1);
24                curr = new Component(
25                    Math.max(curr.value, top.value),
26                    top.left,
27                    curr.right
28                );
29            }
30            stack.add(curr);
31        }
32
33        for (Component comp : stack) {
34            for (int i = comp.left; i <= comp.right; i++) {
35                ans[i] = comp.value;
36            }
37        }
38
39        return ans;
40    }
41}