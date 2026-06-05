class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int stone: stones) pq.offer(stone);
        while(pq.size()>1){
            int heaviestStone=pq.poll();
            int secondHeaviestStone=pq.poll();
            if(heaviestStone!=secondHeaviestStone) pq.offer(heaviestStone-secondHeaviestStone);  
        }
        return pq.isEmpty()? 0: pq.poll();
    }
}
