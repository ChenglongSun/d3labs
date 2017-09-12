class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //创建字典，方便后面使用
        Set<String> dict = new HashSet<String>();
        for (String s: wordList) {
            dict.add(s);
        }
        //创建queue方便BFS，visited维护已访问过的单词
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);
        
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        
        int lvl = 1;
        //BFS
        while (!queue.isEmpty()) {
            String str = queue.poll();
            //如果poll不为空，进行变形操作
            if (str != null) {
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String word = new String(chars);
                        //Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
                        //如过能变形成end，结束
                        if (word.equals(endWord) && dict.contains(word)) return lvl + 1;
                        //加进queue，继续准备下一层BFS
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {//如果空，是层的结束，如果queue为空，那么结束，不为空，该层BFS结束，后面加一个Null做标记
                lvl++;
                if (!queue.isEmpty()) {
                    queue.add(null);//表示该层已经遍历结束，后面加一个null表示下下一层的开始
                }
            }
        }
        return 0;
    }
}