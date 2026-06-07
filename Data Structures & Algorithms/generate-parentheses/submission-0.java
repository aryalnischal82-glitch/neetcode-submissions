class Solution {
    int n;
    StringBuilder str;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        this.str=new StringBuilder();
        this.res=new ArrayList<>();
        dfs(0,0);
        return res;

    }

    private void dfs(int open, int close){
        if(open==close && open==n){
            res.add(str.toString());
            return;
        }
        if(open<n){
             str.append("(");
             dfs(open+1,close);
             str.deleteCharAt(str.length()-1);

        }
        if(close<open){
            str.append(")");
            dfs(open,close+1);
            str.deleteCharAt(str.length()-1);
        }

    }
}
