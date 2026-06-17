class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        int INF=Integer.MAX_VALUE;
        int ROWS=grid.length;
        int COLS=grid[0].length;
        int[][] DIRS=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        Queue<int[]> queue=new LinkedList<>();
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]==0) queue.offer(new int[]{r,c});
            }
        }

        while(!queue.isEmpty()){
            int size=queue.size();
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];

            for(int i=0;i<size;i++){
                for(int[] DIR: DIRS){
                int nr=r+DIR[0];
                int nc=c+DIR[1];
                if(nr<0 || nc<0 || nr>=ROWS || nc>=COLS || grid[nr][nc]!=INF) continue;
                grid[nr][nc]=1+grid[r][c];
                queue.offer(new int[]{nr,nc});
                }
            }
           
        }
    }
}
