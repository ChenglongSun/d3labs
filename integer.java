class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] bucket = new List[s.length() + 1];
        for (char x: map.keySet()) {
            int i = map.get(x);
            if (bucket[i] == null) bucket[i] = new ArrayList<Character>();
            bucket[i].add(x);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char key : bucket[i]) {
                    for (int j = 0; j < map.get(key); j++) {
                        sb.append(key);
                    }
                }
            }
        }
        return sb.toString();
    }
}