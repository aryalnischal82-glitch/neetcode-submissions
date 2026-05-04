class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0) return false;
        Set<String> set=new HashSet<>();
        int ROWS=board.length;
        int COLS=board[0].length;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(board[i][j]=='.') continue;
                String rowStr="Element "+board[i][j]+" present in row "+i+" .";
                String colStr="Element "+board[i][j]+" present in col "+j+" .";
                String boxStr="Element "+board[i][j]+" present in box row"+i/3+"box col "+j/3+" .";

                if(set.contains(rowStr) || set.contains(colStr) || set.contains(boxStr)){
                    System.out.println(i);
                    System.out.println(j);
                    System.out.println(rowStr);
                    System.out.println(colStr);
                    System.out.println(boxStr);
                    return false;
                } 
                set.add(rowStr);
                set.add(colStr);
                set.add(boxStr);
            }
       }
       return true;   
    }
}
