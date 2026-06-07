class Solution {
    List<Integer> list;
    int[] nums;
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        this.list=new ArrayList<>();
        this.nums=nums;
        this.res=new ArrayList<>();
        dfs();
        return res;

    }

    private void dfs(){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>nums.length) return;

        for(int num: nums){
            if(list.contains(num)) continue;
            list.add(num);
            dfs();
            list.remove(list.size()-1);
        }
    }
}
