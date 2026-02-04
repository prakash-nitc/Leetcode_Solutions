1class Solution {
2    static class Triple {
3        int p, q;
4        long sum;
5        Triple(int p, int q, long sum){
6            this.p = p;
7            this.q = q;
8            this.sum = sum;
9        }
10    }
11    public List<Triple> decompose(int[] nums){
12        int n = nums.length;
13        List <Triple> subarrays = new ArrayList<>();
14
15        int l = 0;
16        long sum = nums[0];
17
18        for(int i = 1; i < n; i ++){
19            // If we fail strict decreasing at boundary i-1 -> i, end the current subarray.
20            if(nums[i - 1] <= nums[i]){
21                subarrays.add(new Triple(l, i - 1, sum));
22                l = i;
23                sum = 0;
24            }
25            sum += nums[i];
26        }
27        // last subarray
28        subarrays.add(new Triple(l, n - 1, sum));
29        return subarrays;
30    }
31
32    public long maxSumTrionic(int[] nums){
33        int n = nums.length;
34
35        long[] maxEndingAt = new long[n];
36        for(int i = 0; i < n; i ++){
37            maxEndingAt[i] = nums[i];
38            if(i > 0 && nums[i - 1] < nums[i]){
39                if(maxEndingAt[i - 1] > 0){
40                    maxEndingAt[i] += maxEndingAt[i - 1];
41                }
42            }
43        }
44
45        long[] maxStartingAt = new long[n];
46        for(int i = n - 1; i >= 0; i --){
47            maxStartingAt[i] = nums[i];
48            if(i < n - 1 && nums[i] < nums[i + 1]){
49                if(maxStartingAt[i + 1] > 0){
50                    maxStartingAt[i] += maxStartingAt[i + 1];
51                }
52            }
53        }
54
55        List <Triple> PQS = decompose(nums);
56        long ans = Long.MIN_VALUE;
57
58        for(Triple t : PQS){
59            int p = t.p;
60            int q = t.q;
61            long sum = t.sum;
62
63            if(p > 0 && nums[p - 1] < nums[p] &&
64               q < n - 1 && nums[q] < nums[q + 1] &&
65               p < q){
66                long cand = maxEndingAt[p - 1] + sum + maxStartingAt[q + 1];
67                if(cand > ans){
68                    ans = cand;
69                }
70            }
71        }
72        return ans;
73    }
74}