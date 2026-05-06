class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int maxArea=0;
        int currArea=0;
        while(l<r){
            currArea=(r-l)*Math.min(heights[r],heights[l]);
            maxArea=Math.max(maxArea,currArea);
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
