1import java.util.Arrays;
2
3class Solution {
4    public int[] sortByBits(int[] arr) {
5        // Convert to Integer[] so we can use a comparator
6        Integer[] boxed = new Integer[arr.length];
7        for (int i = 0; i < arr.length; i++) {
8            boxed[i] = arr[i];
9        }
10
11        Arrays.sort(boxed, (a, b) -> {
12            int bitsA = Integer.bitCount(a);
13            int bitsB = Integer.bitCount(b);
14            if (bitsA != bitsB) {
15                return bitsA - bitsB;      // sort by number of 1 bits
16            }
17            return a - b;                   // tie-break by value
18        });
19
20        // Copy back to int[]
21        for (int i = 0; i < arr.length; i++) {
22            arr[i] = boxed[i];
23        }
24        return arr;
25    }
26}
27