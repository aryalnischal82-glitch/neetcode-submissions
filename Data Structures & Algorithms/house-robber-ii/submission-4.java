class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int l=nums.length;
        if(l==1) return nums[0];
        if(l==2) return Math.max(nums[0],nums[1]);
        return Math.max(robLinear(Arrays.copyOfRange(nums,0,l-1),new HashMap<>()),robLinear(Arrays.copyOfRange(nums,1,l),new HashMap<>()));
    }

    public int robLinear(int[] nums, Map<Integer,Integer> cache) {
        //cache {key,val} key max rob till kth house including 'k'
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int l=nums.length;
        cache.put(0,nums[0]);
        if(l==1) return nums[0];
        if(l==2) return Math.max(nums[0],nums[1]);
        cache.put(1,Math.max(nums[0],nums[1]));
        return dfs(l-1,nums,cache);
    }
    private int dfs(int n, int[] nums, Map<Integer,Integer> cache){
        if(cache.containsKey(n)) return cache.get(n);
        int val=Math.max(nums[n]+dfs(n-2,nums,cache),dfs(n-1,nums,cache));
        cache.put(n,val);
        return val;
    }
}
