class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf=new UnionFind(edges.length+1);
        for(int[] edge: edges){
            if(!uf.union(edge[0],edge[1])) return edge;
        }
        return new int[2];
    }
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

        private int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        private boolean union(int x, int y){
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
}

