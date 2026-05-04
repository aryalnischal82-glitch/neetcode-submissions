class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        if(nums==null || nums.length==0) return 0;
        for(int num: nums) set.add(num);
        int currMax=1;
        int globalMax=1;
        for(int num: nums){
            if(set.contains(num+1)) continue;
            while(set.contains(num-1)){
                currMax++;
                num=num-1;
            }
            globalMax=Math.max(currMax,globalMax);
            currMax=1;
        }
        return globalMax;
    }
}
