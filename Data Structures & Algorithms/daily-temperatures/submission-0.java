class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>(); //stack would have idx 
        int[] res=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int topIdx=stack.pop();
                res[topIdx]=i-topIdx;
            }
           stack.push(i);
        }
        return res;
    }
}
