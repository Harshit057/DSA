import java.util.*;

class Solution {  // Ensure the class is named "Solution"
    public int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to find all primes up to right
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime
        
        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Collect primes in the range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                primes.add(num);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.closestPrimes(10, 19))); // Output: [11, 13]
        System.out.println(Arrays.toString(sol.closestPrimes(4, 6)));   // Output: [-1, -1]
    }
}
