class Solution {
    int[][] points;
    public int minCostConnectPoints(int[][] points) {
        this.points=points;
        int l=points.length;
        //{{x,y},[{x,y,mhd}]}
        //pq->[x1,y1,x2,y2,mh]
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                edges.add(new int[]{i,j,getManhattanDistance(i,j)});
            }
        }
        Collections.sort(edges,(a,b)->a[2]-b[2]);

        UnionFind uf=new UnionFind(l);
        int minCost=0;
        int numEdges=0;
        for(int[] edge: edges){
            int p1=edge[0];
            int p2=edge[1];
            int currCost=edge[2];
            if(!uf.areConnected(p1,p2)){
                uf.union(p1,p2);
                minCost+=currCost;
                numEdges++;
                if(numEdges==l-1) break;
            }
        }

        return minCost;
    }

    private int getManhattanDistance(int p1, int p2){
        return Math.abs(points[p1][0]-points[p2][0])+Math.abs(points[p1][1]-points[p2][1]);
    }
}

class Point{
    int x;
    int y;

}

class Points{
    Point p1;
    Point p2;
    int mh;


}
class UnionFind{
        int[] size;
        int[] parent;
        int n;

        public UnionFind(int n){
            this.n=n;
            this.size=new int[n];
            this.parent=new int[n];

            for(int i=1;i<n;i++){
                size[i]=1;
                parent[i]=i;
            }
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int parentX=find(x);
            int parentY=find(y);
            if(parentX==parentY) return false;
            if(size[parentX]>size[parentY]){
                //connect y to x 
                size[parentX]+=size[parentY];
                parent[parentY]=parentX;
            }else{  
                size[parentY]+=size[parentX];
                parent[parentX]=parentY;
                //connect x to y
            }
            return true;
        }

        private boolean areConnected(int x, int y){
            return find(x)==find(y);
        }
}

