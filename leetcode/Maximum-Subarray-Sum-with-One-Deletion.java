1class Solution {
2    public int maximumSum(int[] arr) {
3        int no_Dlt_best_ending= arr[0];
4        int one_Dlt_best_ending= Integer.MIN_VALUE;
5        int largest_sum=arr[0];
6
7        for(int i=1; i<arr.length; i++)
8        {
9            int prev_no_dlt= no_Dlt_best_ending;
10            int prev_one_dlt= one_Dlt_best_ending;
11
12            //2 choices for normal case
13            no_Dlt_best_ending= Math.max(prev_no_dlt+ arr[i], arr[i]);
14            
15            int temp;
16            if(prev_one_dlt== Integer.MIN_VALUE)
17            {
18                temp = arr[i]; //first time encountering a element
19            }
20            else
21            {
22                temp= prev_one_dlt + arr[i];
23            }
24
25            one_Dlt_best_ending= Math.max(temp, prev_no_dlt);
26
27            largest_sum= Math.max(largest_sum, Math.max(no_Dlt_best_ending,one_Dlt_best_ending));
28
29        }
30        return largest_sum;
31
32    }
33}