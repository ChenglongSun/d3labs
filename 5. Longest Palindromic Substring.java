class Solution {
    int lo, max;
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        
        for (int i = 0; i < len; i++) {
            palindromeCheck(s, i, i);
            palindromeCheck(s, i, i + 1);
        }
        return s.substring(lo, lo + max);
    }
    public void palindromeCheck(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (max < j - i - 1) {
            lo = i + 1;
            max = j - i - 1;
        }
    }
}