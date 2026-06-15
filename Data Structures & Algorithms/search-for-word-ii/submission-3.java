class Solution {
    char[][] board;
    String[] words;
    List<String> res;
    Node root;
    int ROWS;
    int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        this.board=board;
        this.words=words;
        this.res=new ArrayList<>();
        this.root=new Node();
        this.ROWS=board.length;
        this.COLS=board[0].length;

        //adding all words to the trie root
        for(String word: words){
            Node curr=root;
            for(char c: word.toCharArray()){
                if(curr.children[c-'a']==null){
                    curr.children[c-'a']=new Node();
                }
                curr=curr.children[c-'a'];
            }
            curr.word=word;
        }
        
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                char currChar=board[r][c];
                if(root.children[currChar-'a']!=null) dfs(root,r,c);
            }
        }
        return res;   
    }

    private void dfs(Node node, int r, int c){
        if(node==null) return;
        if(node.word!=null){
            res.add(node.word);
            node.word=null;
        }
        if(r<0 || r==ROWS || c<0 || c==COLS || board[r][c]=='#' || (node.children[board[r][c]-'a']==null)) return;
        char currChar=board[r][c];
        board[r][c]='#';
        int[][] DIRS=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] DIR: DIRS) dfs(node.children[currChar-'a'],r+DIR[0],c+DIR[1]);
        board[r][c]=currChar;
    }
}

class Node{
    Node[] children;
    String word;

    public Node(){
        this.children=new Node[26];
        this.word=null;
    }
}
