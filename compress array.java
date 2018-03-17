class Solution {
    public int compress(char[] chars) {
        int idx = 0, ans = 0;
        while (idx < chars.length) {
            char cur = chars[idx];
            int count = 0;
            while (idx < chars.length && chars[idx] == cur) {
                count++;
                idx++;
            }
            chars[ans++] = cur;
            if (count != 1) {
                char[] digit = Integer.toString(count).toCharArray(); 把count先转换成String，在转换为char[]
                for (char c : digit) { 这样写比较好～～～
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}