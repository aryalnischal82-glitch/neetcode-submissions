class Solution {
    Map<String,PriorityQueue<String>> map;
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        this.map=new HashMap<>();
        this.res=new ArrayList<>();
        for(List<String> ticket: tickets){
            String from=ticket.get(0);
            String to=ticket.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String curr){
        PriorityQueue<String> tos=map.get(curr);
        while(tos!=null && !tos.isEmpty()){
            dfs(tos.poll());
        }
        res.add(curr);
    }
}
