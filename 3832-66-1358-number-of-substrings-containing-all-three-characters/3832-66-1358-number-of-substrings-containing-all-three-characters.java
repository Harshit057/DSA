class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] freq = new int[3]; // To track frequency of 'a', 'b', and 'c'
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;
            
            // Move the left pointer while we have at least one occurrence of all three characters
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right; // All substrings ending from right to end are valid
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        
        return count;
    }
}