class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String s : strs) {
            char[] sChar = s.toCharArray();
            Arrays.sort(sChar);
            String key = String.valueOf(sChar);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}