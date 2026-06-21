class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Set<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        for(String word: wordList) set.add(word);
        if(!set.contains(endWord) || beginWord.length()!=endWord.length()) return 0;
        visited.add(beginWord);
        queue.offer(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                char[] cArr=curr.toCharArray();
                for(int j=0;j<cArr.length;j++){
                    char origChar=cArr[j];
                    for(char ch='a';ch<='z';ch++){
                        if(ch==origChar) continue;
                        cArr[j]=ch;
                        String newWord=String.valueOf(cArr);
                        if(!visited.contains(newWord) && set.contains(newWord)){
                            queue.offer(String.valueOf(cArr));
                            visited.add(newWord);
                            if(newWord.equals(endWord)) return level;
                        } 
                    }
                    cArr[j]=origChar;
                }
            }
        }
        return 0;

        
    }
}
