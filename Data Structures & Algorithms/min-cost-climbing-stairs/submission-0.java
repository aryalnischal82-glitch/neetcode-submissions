class Solution {
    Map<Integer,Integer> cache;
    int[] cost;
    public int minCostClimbingStairs(int[] cost) {
        this.cache=new HashMap<>();
        this.cost=cost;
        int l=cost.length;
        //cache key,val the cost to reach that point
        cache.put(0,0);
        cache.put(1,0);
        return dfs(l);
    }

    private int dfs(int n){
        if(cache.containsKey(n)) return cache.get(n);
        int val=Math.min(cost[n-1]+dfs(n-1),cost[n-2]+dfs(n-2));
        cache.put(n,val);
        return val;
    }
}
