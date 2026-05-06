1class Solution {
2    public int maxProfit(int[] prices) {
3        int buy1 = Integer.MIN_VALUE;
4        int sell1 = 0;
5        int buy2 = Integer.MIN_VALUE;
6        int sell2 = 0;
7        for (int p : prices) {
8            buy1 = Math.max(buy1, -p);
9            sell1 = Math.max(sell1, buy1 + p);
10            buy2 = Math.max(buy2, sell1 - p);
11            sell2 = Math.max(sell2, buy2 + p);
12        }
13        return sell2;
14    }
15}