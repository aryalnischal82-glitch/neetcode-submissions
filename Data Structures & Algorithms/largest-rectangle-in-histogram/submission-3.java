class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty() || stack.peek()[1]<heights[i]){
                stack.push(new int[]{i,heights[i]});
            }else{
                int putIdx=i;
                while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                    int[] prevVal=stack.pop();
                    int prevIdx=prevVal[0];
                    int prevHeight=prevVal[1];
                    maxArea=Math.max(maxArea,prevHeight*(i-prevIdx)); 
                    putIdx=prevIdx;
                }
                stack.push(new int[]{putIdx,heights[i]});
            }
        }
        while(!stack.isEmpty()){
            int[] currVal=stack.pop();
            int currIdx=currVal[0];
            int currHeight=currVal[1];
            maxArea=Math.max(maxArea,currHeight*(heights.length-currIdx));
        }
        return maxArea;
    }
}
