class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        Set<String> operands=new HashSet<>();
        operands.add("+");
        operands.add("-");
        operands.add("/");
        operands.add("*");
        for(String token: tokens){
            if(!operands.contains(token)){
                stack.push(Integer.parseInt(token));
            }else{
                int lastVal=stack.pop();
                int secondLastVal=stack.pop();
                int res=0;
                if(token.equals("+")){
                    res=secondLastVal+lastVal;
                }else if(token.equals("-")){
                    res=secondLastVal-lastVal;
                }else if(token.equals("*")){
                    res=secondLastVal*lastVal;
                }else{
                    res=secondLastVal/lastVal;
                }
                stack.push(res);
            }
        }
        return stack.pop();

    }
}
