class Solution {
    int[] nums;
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums=nums;
        this.res=new ArrayList<>();
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int i, List<Integer> curr){
        if(i==nums.length){
            this.res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        dfs(i+1,curr);
        curr.remove(curr.size()-1);
        dfs(i+1,curr);
    }
}


//at each branch, choose or not choose 