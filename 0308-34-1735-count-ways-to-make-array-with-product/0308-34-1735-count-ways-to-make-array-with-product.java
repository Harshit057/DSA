class Solution {
    static final int MOD = 1_000_000_007;
    static long[] fact, invFact;

    public int[] waysToFillArray(int[][] queries) {
        int maxN = 0, maxK = 0;
        for (int[] q : queries) {
            maxN = Math.max(maxN, q[0]);
            maxK = Math.max(maxK, q[1]);
        }

        int maxExp = (int) (Math.log(maxK) / Math.log(2)) * maxN + 10;
        buildFactorials(maxN + maxExp);

        int[] spf = smallestPrimeFactor(maxK);
        int[] res = new int[queries.length];

        for (int idx = 0; idx < queries.length; idx++) {
            int n = queries[idx][0];
            int k = queries[idx][1];
            long ans = 1;
            while (k > 1) {
                int prime = spf[k];
                int count = 0;
                while (k % prime == 0) {
                    count++;
                    k /= prime;
                }
                ans = ans * nCr(n + count - 1, count) % MOD;
            }
            res[idx] = (int) ans;
        }
        return res;
    }

    private void buildFactorials(int size) {
        fact = new long[size + 1];
        invFact = new long[size + 1];
        fact[0] = 1;
        for (int i = 1; i <= size; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[size] = pow(fact[size], MOD - 2);
        for (int i = size - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    private long nCr(int n, int r) {
        if (r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private int[] smallestPrimeFactor(int n) {
        int[] spf = new int[n + 1];
        for (int i = 2; i <= n; i++) spf[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
        return spf;
    }
}
