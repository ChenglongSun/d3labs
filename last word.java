class Solution {
    public int lengthOfLastWord(String s) {
    	
    	if(s == null)
    		return 0;

    	return s.trim().length() - s.trim().lastIndexOf(' ') - 1;
    	
    }
}