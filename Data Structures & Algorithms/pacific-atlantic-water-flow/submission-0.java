class Solution {
    int[][] heights;
    List<List<Integer>> res;
    int ROWS;
    int COLS;
    boolean[][] canVisitPacific;
    boolean[][] canVisitAtlantic;
    int[][] DIRS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        this.res=new ArrayList<>();
        this.ROWS=heights.length;
        this.COLS=heights[0].length;
        this.canVisitPacific=new boolean[ROWS][COLS];
        this.canVisitAtlantic=new boolean[ROWS][COLS];
        this.DIRS=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};


        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(r==0 || c==0) dfs(r,c,canVisitPacific, -1);
                if(r==ROWS-1 || c==COLS-1) dfs(r,c,canVisitAtlantic,-1);
            }
        }

        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(canVisitPacific[r][c] && canVisitAtlantic[r][c]){
                    List<Integer> curr=new ArrayList<>();
                    res.add(List.of(r,c));
                }
            }
        }
        return res;

    }

    private void dfs(int r, int c, boolean[][] canVisit, int prevHeight){
        if(r<0 || r>=ROWS || c<0 || c>=COLS || canVisit[r][c] || heights[r][c]<prevHeight) return;
        canVisit[r][c]=true;

        for(int[] DIRS: DIRS){
            int nr=r+DIRS[0];
            int nc=c+DIRS[1];
            dfs(nr,nc,canVisit,heights[r][c]);
        }

    }
}
