class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuffer();
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) { // vertically down
                sb[idx].append(chars[i++]);
            }
            for (int idx = numRows - 2; idx > 0 && i < len; idx--) { // obliquely up
                sb[idx].append(chars[i++]);
            }
        }
        for (int idx = 1; idx < numRows; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}