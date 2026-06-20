class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length) return false;
        UnionFind uf=new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0],edge[1])) return false;
        }
        return true;
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

            for(int i=0;i<n;i++){
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
