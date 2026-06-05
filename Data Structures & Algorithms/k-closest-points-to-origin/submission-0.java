class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // we need a max heap of size k 
    PriorityQueue<Point> pq=new PriorityQueue<>((a,b)->b.dist-a.dist);
    for(int[] point: points){
        int dist=point[0]*point[0]+point[1]*point[1];
        pq.offer(new Point(point,dist));
        if(pq.size()>k) pq.poll();
    }

    int[][] res=new int[k][2];
    int i=0;
    while(!pq.isEmpty()){
        res[i++]=pq.poll().point;
    }
    i=0;
    int j=res.length-1;
    while(i<j){
        int[] temp=res[i];
        res[i]=res[j];
        res[j]=temp;
        i++;
        j--;
    }
    return res;

    }
}

class Point{
    int[] point;
    int dist;

    public Point(int[] point, int dist){
        this.point=point;
        this.dist=dist;
    }
}



//Nlog(N)
