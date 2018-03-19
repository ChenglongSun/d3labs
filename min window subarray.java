class Solution {
    public String minWindow(String s, String t) {
        int[] raw = new int[128];
        int[] target = new int[128];
        int len = t.length();
        
        for (char c : t.toCharArray()) {
            target[c]++;
        }
        
        int start = 0;
        int end = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        
        while (end < s.length()) {
            if (target[s.charAt(end)] != 0) {
                if (target[s.charAt(end)] > raw[s.charAt(end)]) count++;
            }
            raw[s.charAt(end)]++;
            
            if (count == len) {
                while (target[s.charAt(start)] == 0 || raw[s.charAt(start)] > target[s.charAt(start)]) {
                    if (raw[s.charAt(start)] > target[s.charAt(start)]) raw[s.charAt(start)]--;
                    start++;
                }
                if (min > end - start + 1) {
                    min = end - start + 1;
                    ans = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return ans;
    }
}