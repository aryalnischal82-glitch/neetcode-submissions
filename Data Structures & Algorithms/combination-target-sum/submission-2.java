class Solution {
    int[] nums;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        this.res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,0, new ArrayList<>());
        return res;
    }

    private void dfs(int idx, int runningSum, List<Integer> curr){
        if(runningSum==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i]+runningSum>target) continue;
            curr.add(nums[i]);
            dfs(i,nums[i]+runningSum,curr);
            curr.remove(curr.size()-1);
        }
    }
}
