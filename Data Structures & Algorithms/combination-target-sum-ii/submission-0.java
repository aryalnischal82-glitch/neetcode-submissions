class Solution {
    int[] candidates;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates=candidates;
        this.res=new ArrayList<>();
        this.target=target;
        Arrays.sort(candidates);
        dfs(0,0,new ArrayList<>());
        return res;
    }

    private void dfs(int idx, int runningSum, List<Integer> curr){
        if(runningSum==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(runningSum>target || idx>=candidates.length) return;
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            int total=runningSum+candidates[i];
            if(total>target) continue;
            curr.add(candidates[i]);
            dfs(i+1,total,curr);
            curr.remove(curr.size()-1);
        }
    }
}
