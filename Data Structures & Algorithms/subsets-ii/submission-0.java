class Solution {
    int[] nums;
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums=nums;
        this.res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,new ArrayList<>());
        return res;
    }

    private void dfs(int idx, List<Integer> curr){
        if(idx==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        dfs(idx+1,curr);
        curr.remove(curr.size()-1);
        while((idx+1)<nums.length && nums[idx]==nums[idx+1]) idx++;
        dfs(idx+1,curr);
    }
}
