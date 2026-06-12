class Solution {
    char[][] board;
    String word;
    int ROWS;
    int COLS;
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        this.ROWS=board.length;
        this.COLS=board[0].length;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(word.charAt(0)==board[r][c] && dfs(r,c,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int idx){
        if(idx==word.length()) return true;
        if(r<0 || r>=ROWS || c<0 || c>=COLS || board[r][c]=='#' || board[r][c]!=word.charAt(idx)) return false;
        boolean isWordMatch=false;
        char temp=board[r][c];
        board[r][c]='#';
        isWordMatch=dfs(r+1,c,idx+1) || dfs(r-1,c,idx+1) || dfs(r,c+1,idx+1) || dfs(r,c-1,idx+1);
        board[r][c]=temp;
        return isWordMatch;
    }
}
