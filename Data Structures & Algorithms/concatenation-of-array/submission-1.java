class Solution {
    public int[] getConcatenation(int[] nums) {
        int l=nums.length;
        int[] res=new int[2*l];
        for(int i=0;i<res.length;i++){
            res[i]=nums[i%l];
        }
        return res;
    }
}