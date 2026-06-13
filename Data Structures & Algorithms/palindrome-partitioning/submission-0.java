class Solution {
    List<List<String>> res;
    String s;
    List<String> curr;
    public List<List<String>> partition(String s) {
        this.res=new ArrayList<>();
        this.curr=new ArrayList<>();
        this.s=s;

        dfs(0);
        return res;

    }

    private void dfs(int idx){
        if(idx==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx,i+1))){
                curr.add(s.substring(idx,i+1));
                dfs(i+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}
