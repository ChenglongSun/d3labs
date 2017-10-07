class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> dict = new HashSet<>();
        for (String s : wordList) dict.add(s);
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        
        
        int level = 1;
        String prev = null;
        String[] temp = new String[];
        int depth;
        while (!queue.isEmpty()) {
            String str = queue.poll();
            prev = str;
            map.put(prev, null);
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        char[i] = j;
                        String word = new String(chars);
                        if (word.equals(endWord) && dict.contains(endWord)) {
                            temp.add(word);
                            level++;
                            depth = level;
                            break;
                        } else if(dict.contains(word) && !map.containsKey(word)) {
                            temp.add(word);
                            queue.add(word);
                        }
                    }
                }
            } else {
                level++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                    map.put(prev, temp);
                    temp = null;
                }
            }
        }
        
        List<List<String>> res = new ArrayList<>();
    }
}