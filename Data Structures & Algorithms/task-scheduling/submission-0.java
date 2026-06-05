class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char task: tasks){
            freq[task-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int f: freq) if(f>0) pq.offer(f);
        Queue<int[]> coolDown=new LinkedList<>();
        //task_count, when available
        int time=0;
        while(!pq.isEmpty() || !coolDown.isEmpty()){
            if(!pq.isEmpty()){
               int highestFreq=pq.poll();
               if(highestFreq>1) coolDown.offer(new int[]{highestFreq-1,time+n+1});
            }
            time++;
            if(!coolDown.isEmpty() && coolDown.peek()[1]==time){
                int count=coolDown.poll()[0];
                if(count>=1)pq.offer(count);
            }
        }
        return time;

        
    }
}
