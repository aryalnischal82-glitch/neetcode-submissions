class Solution {
    List<List<String>> res;
    int n;
    Set<Integer> colSet;
    Set<Integer> posDiag;
    Set<Integer> negDiag;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        this.res=new ArrayList<>();
        this.posDiag=new HashSet<>();
        this.negDiag=new HashSet<>();
        this.colSet=new HashSet<>();
        this.board=new char[n][n];

        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                board[r][c]='.';
            }
        }

        dfs(0);
        return res;
    }

    private void dfs(int r){
        if(r==n){
            //capture board
            List<String> snapshot=new ArrayList<>();
            for(int row=0;row<n;row++){
                StringBuilder strB=new StringBuilder();
                for(int col=0;col<n;col++){
                    strB.append(board[row][col]);
                }
                snapshot.add(strB.toString());            
                }
            res.add(snapshot);
            return;
        }
        for(int c=0;c<n;c++){
            if(colSet.contains(c) || posDiag.contains(r-c) || negDiag.contains(r+c)) continue;
            colSet.add(c);
            posDiag.add(r-c);
            negDiag.add(r+c);
            board[r][c]='Q';
            dfs(r+1);
            colSet.remove(c);
            posDiag.remove(r-c);
            negDiag.remove(r+c);
            board[r][c]='.';
        }
    }
}
