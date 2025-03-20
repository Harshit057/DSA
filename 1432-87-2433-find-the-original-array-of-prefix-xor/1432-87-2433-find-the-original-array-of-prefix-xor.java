import java.util.*;

public class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];

        // The first element remains the same
        arr[0] = pref[0];

        // Compute the rest of the array
        for (int i = 1; i < n; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }

    // Main function to test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1
        int[] pref1 = {5,2,0,3,1};
        System.out.println(Arrays.toString(sol.findArray(pref1))); // Output: [5,7,2,3,2]

        // Test case 2
        int[] pref2 = {13};
        System.out.println(Arrays.toString(sol.findArray(pref2))); // Output: [13]
    }
}
