class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int len=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++){
            int curr=nums[i];
            if(curr>0) break;
            int j=i+1;
            int k=len-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(j<k){
                int sum=curr+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> currList=List.of(nums[i],nums[j],nums[k]);
                    res.add(currList);
                    j++;
                    k--;
                    while(j<k && j>i+1 && nums[j]==nums[j-1]) j++;
                    while(j<k && k<len-1 && nums[k]==nums[k+1]) k--;
                }else if(sum>0){
                    k--;
                }else{
                    //sum<0
                    j++;
                }
            }
        }
        return res;
    }
}
