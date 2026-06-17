class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS=grid.length;
        int COLS=grid[0].length;
        int fresh=0;
        Queue<int[]> queue=new LinkedList<>();
        int mins=0;
        int[][] DIRS=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]==1){
                    fresh++;
                }else if(grid[r][c]==2){
                    queue.offer(new int[]{r,c});
                }
            }
        }
        if(fresh==0) return 0;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                int r=curr[0];
                int c=curr[1];
                for(int[] DIR: DIRS){
                    int nr=r+DIR[0];
                    int nc=c+DIR[1];
                    if(nr<0 || nc<0 || nr>=ROWS || nc>=COLS || grid[nr][nc]!=1) continue;
                    fresh--;
                    grid[nr][nc]=2;
                    queue.offer(new int[]{nr,nc});
                }
            }
            mins++;
            if(fresh==0) break;
        }
        return (fresh==0)? mins: -1;
    }

}
