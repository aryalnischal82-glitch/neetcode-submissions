class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        if(l1>l2) return findMedianSortedArrays(nums2,nums1);
        int l=0;
        int r=l1;
        int total=l1+l2;
        int half=total/2;
        while(l<=r){
            int m1=l+(r-l)/2;
            int m2=half-m1;
            //m1+m2 makes left partition 

            int left1=(m1==0)? Integer.MIN_VALUE: nums1[m1-1]; 
            int left2=(m2==0)? Integer.MIN_VALUE: nums2[m2-1];
            int right1=(m1==l1)? Integer.MAX_VALUE: nums1[m1];
            int right2=(m2==l2)? Integer.MAX_VALUE: nums2[m2];

            if(left1<=right2 && left2<=right1){
                //found it 
                int leftMax=Math.max(left1,left2);
                int rightMin=Math.min(right1,right2);
                if(total%2==0){
                    return (double) (leftMax+rightMin)/2;
                }else{
                    return Math.min(right1,right2);
                }

            }else if(left1>right2){
                r=m1-1;
            }else if(left2>right1){
                l=m1+1;
            }

        }
        return -1;
    }
}
