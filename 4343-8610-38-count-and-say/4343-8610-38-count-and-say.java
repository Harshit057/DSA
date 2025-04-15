public class Solution {
    public String countAndSay(int n) {
        // Base string for n == 1
        String s = "1";
        
        // Build the sequence up to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            // Process the previous sequence string s
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++; // Increase the count for the same digit
                } else {
                    // Append the count and the digit
                    sb.append(count).append(s.charAt(j - 1));
                    count = 1; // Reset count for new digit
                }
            }
            // Append the count and the last digit of the current string
            sb.append(count).append(s.charAt(s.length() - 1));
            // Update s to be the new sequence built from the previous sequence
            s = sb.toString();
        }
        return s;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example: countAndSay(4) should return "1211"
        System.out.println(solution.countAndSay(4)); // Output: "1211"
    }
}
