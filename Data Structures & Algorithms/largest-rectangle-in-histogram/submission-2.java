class Solution {
    public int largestRectangleArea(int[] heights) {
       Stack<int[]> stack=new Stack<>();
       //stack will have both <idx, height> 
       int maxArea=0;
       for(int i=0;i<heights.length;i++){
            int putIdx=i;
            while(!stack.isEmpty() && stack.peek()[1]>=heights[i]){
                int topIdx=stack.peek()[0];
                int topHeight=stack.peek()[1];
                stack.pop();
                maxArea=Math.max(maxArea,topHeight*(i-topIdx));
                putIdx=topIdx;
            }
            stack.push(new int[]{putIdx,heights[i]});
       }
       int lastIdx=stack.peek()[0];
        while(!stack.isEmpty()){
            int[] topVal=stack.pop();
            maxArea=Math.max(maxArea,(heights.length-topVal[0])*topVal[1]);
        }
       return maxArea;
    }
}
