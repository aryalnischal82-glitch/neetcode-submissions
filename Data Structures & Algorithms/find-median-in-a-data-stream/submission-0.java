class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        this.left=new PriorityQueue<>((a,b)->Integer.compare(b,a)); //max heap
        this.right=new PriorityQueue<>((a,b)->Integer.compare(a,b)); //min heap
    }
    
    public void addNum(int num) {
        left.offer(num);
        //always add to left heap, left can be greater than right by 1, right can be at max size left 
        if(!right.isEmpty() && left.peek()>right.peek()){
            int leftMax=left.poll();
            int rightMin=left.poll();
            left.offer(rightMin);
            right.offer(leftMax);
        }

        if(left.size()>right.size()+1){
            right.offer(left.poll());
        }
        
        if(right.size()>left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        int size=left.size()+right.size();
        if(size%2==0){
            return (double)(left.peek()+right.peek())/2.0;
        }else{
            return left.peek();
        }
    }

   
}
