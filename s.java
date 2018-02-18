class Solution {
    public String minWindow(String s, String t) {
        int[] raw = new int[128];
        int[] target = new int[128];
        
        for (int i = 0; i < t.length(); i++) {
            target[t.charAt(i)]++;
        }
        int min = Integer.MAX_VALUE;
        String res = new String();
        int count = 0, start = 0, end = 0;
        
        while (end < s.length()) {
            if (target[s.charAt(end)] != 0) {
                if (raw[s.charAt(end)] < target[s.charAt(end)]) {
                    count++;
                }
                raw[s.charAt(end)]++;
                
            }
            
            
            if (count == t.length()) {
                while (target[s.charAt(start)] == 0 || raw[s.charAt(start)] > target[s.charAt(start)]) {
                    if (raw[s.charAt(start)] > target[s.charAt(start)]) {
                        raw[s.charAt(start)]--;
                    }
                    start++;
                }
                
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
            end++;
        }
        return res;
    }
}