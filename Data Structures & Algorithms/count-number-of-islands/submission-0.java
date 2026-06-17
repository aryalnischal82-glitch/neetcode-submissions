class Solution {
    Set<String> visited;
    char[][] grid;
    int ROWS;
    int COLS;
    int res;
    public int numIslands(char[][] grid) {
        this.visited=new HashSet<>();
        this.grid=grid;
        this.ROWS=grid.length;
        this.COLS=grid[0].length;
        this.res=0;
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
        dfs(r+1,c);
        dfs(r-1,c);
        dfs(r,c+1);
        dfs(r,c-1);        
    }
}

