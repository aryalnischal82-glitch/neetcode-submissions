class Solution {
    Set<String> visited;
    char[][] grid;
    int ROWS;
    int COLS;
    int res;
    int[][] DIRS;
    public int numIslands(char[][] grid) {
        this.visited=new HashSet<>();
        this.grid=grid;
        this.ROWS=grid.length;
        this.COLS=grid[0].length;
        this.res=0;
        this.DIRS=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                String cell=i+"-"+j;
                if(grid[i][j]=='1' && !visited.contains(cell)){
                    dfs(i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c){
        String cell=r+"-"+c;
        if(r<0 || r>=ROWS || c<0 || c>=COLS || grid[r][c]=='0' || visited.contains(cell)) return;
        visited.add(cell);
        for(int[] DIR: DIRS) dfs(r+DIR[0],c+DIR[1]);     
    }
}

