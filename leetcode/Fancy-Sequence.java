1class Fancy {
2    private static final int MOD = 1_000_000_007;
3
4    // Each stored value x represents the original number before the global transform a * x + b.
5    private List<Long> vals = new ArrayList<>();
6    private long a = 1; // global multiplier
7    private long b = 0; // global adder
8
9    public Fancy() {
10    }
11
12    public void append(int val) {
13        // We want: visible = a * x + b == val  =>  x = (val - b) * inv(a)
14        long x = val;
15        x = (x - b) % MOD;
16        if (x < 0) x += MOD;
17        x = x * modInverse(a, MOD) % MOD;
18        vals.add(x);
19    }
20
21    public void addAll(int inc) {
22        b = (b + inc) % MOD;
23    }
24
25    public void multAll(int m) {
26        a = (a * m) % MOD;
27        b = (b * m) % MOD;
28    }
29
30    public int getIndex(int idx) {
31        if (idx < 0 || idx >= vals.size()) return -1;
32        long x = vals.get(idx);
33        long res = (a * x + b) % MOD;
34        return (int) res;
35    }
36
37    // Fermat's little theorem for modular inverse (MOD is prime)
38    private long modPow(long base, long exp, long mod) {
39        long res = 1;
40        base %= mod;
41        while (exp > 0) {
42            if ((exp & 1) == 1) res = (res * base) % mod;
43            base = (base * base) % mod;
44            exp >>= 1;
45        }
46        return res;
47    }
48
49    private long modInverse(long x, long mod) {
50        if (x == 0) return 0;          // won't be called with 0 for this problem
51        return modPow(x, mod - 2, mod);
52    }
53}
54