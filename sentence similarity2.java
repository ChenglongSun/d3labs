class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        HashMap<String, String> map = new HashMap<>();
        for (String[] str : pairs) {
            String s1 = find(map, str[0]);
            String s2 = find(map, str[1]);
            if (!s1.equals(s2)) map.put(s1, s2);
        }
        
        for (int i = 0; i < words1.length; i++) {
            String root1 = find(map, words1[i]);
            String root2 = find(map, words2[i]);
            if (!words1[i].equals(words2[i]) && !root1.equals(root2)) return false;
        }
        return true;
    }
    public String find(HashMap<String, String> map, String s) {
        if (!map.containsKey(s)) map.put(s, s);
        return s.equals(map.get(s)) ? s: find(map, map.get(s));
    }
}