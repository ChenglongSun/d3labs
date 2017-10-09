class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>(wordList);
        dict.add(beginWord);
        Map<String, Integer> degree = new HashMap<>();
        Map<String, List<String>> getNeighbors = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        bfs(beginWord, endWord, dict, degree, getNeighbors);
        dfs(beginWord, endWord, res, new ArrayList<String>(), degree, getNeighbors);
        return res;
        
    }
    
    public void bfs(String start, String end, Set<String> dict, Map<String, Integer> degree, Map<String, List<String>> getNeighbors) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.add(start);
        getNeighbors.put(start, new ArrayList<String>());
        boolean foundEnd = false;
        degree.put(start, 0);
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                getNeighbors.put(str, new ArrayList<String>());
                int level = degree.get(str);
                List<String> neighbor = neighbors(str, dict);
                for (String n : neighbor) {
                    getNeighbors.get(str).add(n);
                    if (degree.containsKey(n)) continue;
                    if (n.equals(end)) {
                        foundEnd = true;
                        getNeighbors.put(str, new ArrayList<String>(Arrays.asList(new String[]{end})));
                    } else {
                        queue.add(n);
                    }
                    degree.put(n, level + 1);
                }
            }
            if (foundEnd) break;
        }
        
    }
    
    public List<String> neighbors(String str, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                chars[i] = j;
                String word = new String(chars);
                if (dict.contains(word) && !word.equals(str)) {
                    res.add(word);
                } 
            }
        }
        return res;
    }
    
    public void dfs(String start, String end, List<List<String>> res, List<String> temp, Map<String, Integer> degree, Map<String, List<String>> getNeighbors) {
        temp.add(start);
        if (start.equals(end)) {
            res.add(new ArrayList<String>(temp));
            //return;
        } else {
            int level = degree.get(start);
            for (String str : getNeighbors.get(start)) {
                if (degree.get(str) == level + 1) {
                    dfs(str, end, res, temp, degree, getNeighbors);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }
}