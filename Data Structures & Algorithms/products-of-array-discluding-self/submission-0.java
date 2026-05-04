class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int[] leftArr=new int[l];
        int[] rightArr=new int[l];
        leftArr[0]=1;
        rightArr[l-1]=1;
        for(int i=1;i<l;i++){
            leftArr[i]=leftArr[i-1]*nums[i-1];
        }
        for(int i=l-2;i>=0;i--){
            rightArr[i]=rightArr[i+1]*nums[i+1];
        }
        int[] res=new int[l];
        for(int i=0;i<l;i++){
            res[i]=leftArr[i]*rightArr[i];
        }
        return res;
    }
}  
