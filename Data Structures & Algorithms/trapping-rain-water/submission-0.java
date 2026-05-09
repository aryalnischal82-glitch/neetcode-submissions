class Solution {
    public int trap(int[] height) {
        int l=height.length;
        int[] leftHeight=new int[l];
        int[] rightHeight=new int[l];
        //leftHeight(i)=Math.max(height(i-1),leftHeight(i-1))
        //rightHeight(i)=Math.max(height(i+1),rightHeight(i+1))

        for(int i=1;i<l;i++){
            leftHeight[i]=Math.max(height[i-1],leftHeight[i-1]);
        }
        for(int i=l-2;i>=0;i--){
            rightHeight[i]=Math.max(height[i+1],rightHeight[i+1]);
        }

        int res=0;
        for(int i=0;i<l;i++){
            res+=Math.max(0,Math.min(leftHeight[i],rightHeight[i])-height[i]);
        }
        return res;
    }
}

//at any point, (sum(Math.max(0,min(leftMaxHeight,rightMaxHeight)-currHeight))