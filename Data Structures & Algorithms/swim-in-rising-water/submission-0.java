class Solution {
    int[][] grid;
    int ROWS;
    int COLS;
    boolean[][] isVisited;
    public int swimInWater(int[][] grid) {
        this.grid=grid;
        this.ROWS=grid.length;
        this.COLS=grid[0].length;
        this.isVisited=new boolean[ROWS][COLS];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        int[][] DIRS=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        pq.offer(new int[]{0,0,grid[0][0]});
        int res=-1;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int r=curr[0];
            int c=curr[1];
            int max=curr[2];
            // if(currRow<0 || currRow>=ROWS || currCol<0 || currCol>=COLS || isVisited[currRow][currCol]) continue;
            isVisited[r][c]=true;
            if(r==ROWS-1 && c==COLS-1){
                res=max;
                break;
            }
            for(int[] DIR: DIRS){
                int nr=r+DIR[0];
                int nc=c+DIR[1];
                if(nr<0 || nr>=ROWS || nc<0 || nc>=COLS || isVisited[nr][nc]) continue;
                pq.offer(new int[]{nr,nc,Math.max(max,grid[nr][nc])});
            }
        }
        return res;
    }
}
