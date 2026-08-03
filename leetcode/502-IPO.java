class Solution {

    class Pair {
        int capital, profit;

        Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        Pair[] projects = new Pair[profits.length];

        int idx = 0;

        for (int i = 0; i < profits.length; i++) {
            projects[i] = new Pair(capital[i], profits[i]);
        }

        Arrays.sort(projects, (a, b) -> a.capital - b.capital);

        for (int i = 0; i < k; i++) {

            while (idx < profits.length && projects[idx].capital <= w) {
                pq.add(projects[idx].profit);
                idx++;
            }

            if (pq.isEmpty())
                return w;

            int max_profit = pq.poll();
            w += max_profit;
        }

        return w;
    }
}