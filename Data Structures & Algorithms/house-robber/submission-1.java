class Solution {
    Map<Integer,Integer> cache;
    int[] nums;
    public int rob(int[] nums) {
        //cache {key,val} key max rob till kth house including 'k'
        this.cache=new HashMap<>();
        this.nums=nums;
        int l=nums.length;
        cache.put(0,nums[0]);
        if(l==1) return nums[0];
        cache.put(1,Math.max(nums[0],nums[1]));
        return dfs(l-1);
    }
    private int dfs(int n){
        if(cache.containsKey(n)) return cache.get(n);
        int val=Math.max(nums[n]+dfs(n-2),dfs(n-1));
        cache.put(n,val);
        return val;
    }


}
