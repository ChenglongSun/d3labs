class Solution {
    public String minWindow(String s, String t) {
        int[] raw = new int[128];
        int[] target = new int[128];
        int len = t.length();
        
        for (int i = 0; i < len; i++) {
            target[t.charAt(i)]++;
        }
        
        int count = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        
        while (end < s.length()) {
            if (target[s.charAt(end)] != 0) {
                if (raw[s.charAt(end)] < target[s.charAt(end)]) {
                    count++;
                }
                raw[s.charAt(end)]++;
            }
            
            if (count == len) {
                while (raw[s.charAt(start)] > target[s.charAt(start)] || target[s.charAt(start)] == 0) {
                    if (raw[s.charAt(start)] > target[s.charAt(start)]) {
                        raw[s.charAt(start)]--;
                    }
                    start++;
                }
                
                if (min > end - start + 1) {
                    min = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return res;
    }
}