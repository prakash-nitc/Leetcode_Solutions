1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        // All possible prime counts of set bits in this range (max bits <= 20 for 10^6)
4        boolean[] isPrime = new boolean[21];
5        isPrime[2] = true;
6        isPrime[3] = true;
7        isPrime[5] = true;
8        isPrime[7] = true;
9        isPrime[11] = true;
10        isPrime[13] = true;
11        isPrime[17] = true;
12        isPrime[19] = true;
13
14        int ans = 0;
15        for (int x = left; x <= right; x++) {
16            int bits = Integer.bitCount(x);
17            if (isPrime[bits]) {
18                ans++;
19            }
20        }
21        return ans;
22    }
23}
24