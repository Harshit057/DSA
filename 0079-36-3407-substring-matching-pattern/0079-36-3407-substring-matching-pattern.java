class Solution {
    public boolean hasMatch(String s, String p) {  // Renamed to hasMatch
        String[] parts = p.split("\\*", 2);
        String prefix = parts[0];
        String suffix = parts.length > 1 ? parts[1] : "";

        int prefixIndex = s.indexOf(prefix);
        if (prefixIndex == -1) return false; 

        return s.indexOf(suffix, prefixIndex + prefix.length()) != -1;
    }
}
