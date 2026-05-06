1class Solution {
2    public int maxProfit(int[] prices) {
3        int profit = 0;
4        for (int i = 1; i < prices.length; i++) {
5            int diff = prices[i] - prices[i - 1];
6            if (diff > 0) profit += diff;
7        }
8        return profit;
9    }
10}