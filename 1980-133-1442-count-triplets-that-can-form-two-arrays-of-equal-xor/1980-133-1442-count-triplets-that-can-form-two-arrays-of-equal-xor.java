public class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Prefix XOR initialization
        int[] prefixXOR = new int[n + 1];
        prefixXOR[0] = 0; // prefixXOR[i] stores XOR(0, i-1)

        // Compute prefix XOR
        for (int i = 0; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        // Iterate over all (i, k) pairs
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefixXOR[i] == prefixXOR[k + 1]) {
                    count += (k - i);
                }
            }
        }

        return count;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] arr1 = {2,3,1,6,7};
        System.out.println(sol.countTriplets(arr1)); // Output: 4

        // Test case 2
        int[] arr2 = {1,1,1,1,1};
        System.out.println(sol.countTriplets(arr2)); // Output: 10
    }
}
