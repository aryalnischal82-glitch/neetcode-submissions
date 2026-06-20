class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf=new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.n;
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

        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int parentX=find(x);
            int parentY=find(y);
            if(parentX==parentY) return;
            if(size[parentX]>size[parentY]){
                //connect y to x 
                size[parentX]+=size[parentY];
                parent[parentY]=parentX;
            }else{  
                size[parentY]+=size[parentX];
                parent[parentX]=parentY;
                //connect x to y
            }
            n--;
        }
}
