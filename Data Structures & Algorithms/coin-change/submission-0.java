class Solution {
    Map<Integer,Integer> cache;
    int[] coins;
    int amount;
    int maxCoin;
    public int coinChange(int[] coins, int amount) {
        this.cache=new HashMap<>();
        this.coins=coins;
        this.amount=amount;
        this.maxCoin=0;
        for(int coin: coins){
            cache.put(coin,1);
        }
        cache.put(0,0); 
        int res=dfs(amount);
        return res>=Integer.MAX_VALUE/2? -1: res;
    }


    private int dfs(int amount){
        if(cache.containsKey(amount)) return cache.get(amount);
        int val=Integer.MAX_VALUE/2; 
        if(amount<0) return Integer.MAX_VALUE/2;
        for(int coin: coins) val=Math.min(val,1+dfs(amount-coin));
        cache.put(amount,val);
        return val;   
    }
}
