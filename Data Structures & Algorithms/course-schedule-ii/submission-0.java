class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];
        int[] res=new int[numCourses];
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
        int idx=0;
        int numProcessed=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            res[idx++]=curr;
            List<Integer> neighbors=map.get(curr);
            if(neighbors==null) continue;
            for(int neighbor: neighbors){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return (idx==numCourses)? res: new int[0];
    }
}
