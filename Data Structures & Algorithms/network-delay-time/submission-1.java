class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //times->[src,dest,wt]
        int[] res=new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k]=0;
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] time: times){
            int from=time[0];
            int to=time[1];
            int wt=time[2];
            map.putIfAbsent(from,new ArrayList<>());
            map.get(from).add(new int[]{to,wt});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        Set<Integer> visited=new HashSet<>();
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] currSet=pq.poll();
            int currNode=currSet[0];
            int distFromSrc=currSet[1];
            if(visited.contains(currNode)) continue;
            visited.add(currNode);//having a node visited means its shortest dist is finalized, no need to visit again
            List<int[]> neighbors=map.get(currNode);
            if(neighbors==null) continue;
            for(int[] neighbor: neighbors){
                int neighborNode=neighbor[0];
                int edgeWeight=neighbor[1];
                int newDist=distFromSrc+edgeWeight;
                if(visited.contains(neighborNode) || res[neighborNode]<newDist) continue;
                res[neighborNode]=newDist;
                pq.offer(new int[]{neighborNode,newDist});
            }
        }
        int maxDist=Integer.MIN_VALUE;
        for(int i=1;i<res.length;i++){
            int dist=res[i];
            if(dist==Integer.MAX_VALUE) return -1;
            maxDist=Math.max(dist,maxDist);
        }
        return maxDist;

    }
}
