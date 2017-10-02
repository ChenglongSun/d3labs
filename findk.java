class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<String>();
        for (String s : wordList) {
            dict.add(s);
        }
        
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);//
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        int len = 1;
        
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null) {//
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String word = new String(chars);
                        if (word.equals(endWord) && dict.contains(word)) return len + 1;
                        if (!visited.contains(word) && dict.contains(word)) {
                            visited.add(word);
                            queue.add(word);
                        }
                    }
                }
            } else {
                len++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return 0;
    }
}