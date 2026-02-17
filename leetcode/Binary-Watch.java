1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> readBinaryWatch(int turnedOn) {
6        List<String> result = new ArrayList<>();
7
8        // hours: 0–11, minutes: 0–59
9        for (int h = 0; h < 12; h++) {
10            for (int m = 0; m < 60; m++) {
11                // count set bits in hour and minute
12                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
13                    // hour has no leading zero by default with Integer.toString
14                    // minute must be two digits with leading zero if needed
15                    String time = h + ":" + (m < 10 ? "0" + m : String.valueOf(m));
16                    result.add(time);
17                }
18            }
19        }
20
21        return result;
22    }
23}
24