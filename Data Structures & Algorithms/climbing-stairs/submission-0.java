class Solution {
    Map<Integer,Integer> cache;
    public int climbStairs(int n) {
        this.cache=new HashMap<>();
        cache.put(1,1);
        cache.put(0,1);
        return dfs(n);
    }

    private int dfs(int n){
        if(cache.containsKey(n)) return cache.get(n);
        int val=dfs(n-1)+dfs(n-2);
        cache.put(n,val);
        return val;
    }
}
