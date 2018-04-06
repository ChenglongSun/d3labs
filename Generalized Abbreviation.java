class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word, res, 0, 0, "");
        return res;
    }
    
    public void dfs(String word, List<String> res, int pos, int count, String temp) {
        if (pos == word.length()) {
            if (count != 0) temp += count;
            res.add(temp);
        } else {
            dfs(word, res, pos + 1, count + 1, temp);
            dfs(word, res, pos + 1, 0, temp + ((count == 0)? "" : count) + word.charAt(pos));
        }
        
    }
}