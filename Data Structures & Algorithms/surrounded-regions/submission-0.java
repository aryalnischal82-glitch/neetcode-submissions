class Solution {
    char[][] board;
    int ROWS;
    int COLS;
    int[][] DIRS;
    public void solve(char[][] board) {
        this.board=board;
        this.ROWS=board.length;
        this.COLS=board[0].length;
        this.DIRS=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if((r==0 || r==ROWS-1 || c==0 || c==COLS-1)){
                   dfs(r,c);
                }
            }
        }

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if((r==0 || r==ROWS-1 || c==0 || c==COLS-1) && board[r][c]=='S'){
                    dfs(r,c);
                }
            }
        }

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }else if(board[r][c]=='S'){
                    board[r][c]='O';
                }
            }
        }
        

    }

    private void dfs(int r, int c){
        if(r<0 || r>=ROWS || c<0 || c>=COLS || board[r][c]!='O') return;
        board[r][c]='S';
        for(int[] DIR: DIRS){
            int nr=r+DIR[0];
            int nc=c+DIR[1];
            dfs(nr,nc);
        }
    }
}
