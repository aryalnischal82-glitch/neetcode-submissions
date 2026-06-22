class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] res=new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src]=0;
        //loop can run k+1 times
        for(int i=0;i<=k;i++){
            int[] temp=res.clone();
            for(int[] flight: flights){
                int s=flight[0];
                int d=flight[1];
                int c=flight[2];
                if(res[s]==Integer.MAX_VALUE) continue;
                if(temp[d]>res[s]+c) temp[d]=res[s]+c;
            }
            res=temp;
        }
        return res[dst]==Integer.MAX_VALUE? -1: res[dst];
    }
}
