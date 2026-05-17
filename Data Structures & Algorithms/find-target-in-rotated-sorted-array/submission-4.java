class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums=nums;
        this.target=target;
        int minIdx=findMinIdx();
        if(nums[minIdx]==target) return minIdx;
        int l=0;
        int r=nums.length-1;
        int res=-1;
        if(nums[r]>=target){
            //search space-> (minIdx,r)
            res=binarySearch(minIdx,r);
        }else{
            res=binarySearch(l,minIdx);
            //search space->(l,minIdx)
        }
        return res;
    }

    private int binarySearch(int l, int r){
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }


    public int findMinIdx() {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}
