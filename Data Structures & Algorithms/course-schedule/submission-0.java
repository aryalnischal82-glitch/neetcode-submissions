class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] pre: prerequisites){
            int from=pre[1];
            int to=pre[0];
            map.putIfAbsent(from,new ArrayList<>());
            map.get(from).add(to);
            inDegree[to]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.offer(i);
        }
        int numProcessed=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            numProcessed++;
            List<Integer> neighbors=map.get(curr);
            if(neighbors==null) continue;
            for(int neighbor: neighbors){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return numProcessed==numCourses;
    }
}
