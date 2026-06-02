class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    int[] nums;
    public KthLargest(int k, int[] nums) {
        this.pq=new PriorityQueue<>();
        this.k=k;
        this.nums=nums;
        //min heap
        for(int num: this.nums){
            this.pq.offer(num);
            if(pq.size()>k) pq.poll();
        } 
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if(pq.size()>k) pq.poll();
        return this.pq.peek();
    }
}
