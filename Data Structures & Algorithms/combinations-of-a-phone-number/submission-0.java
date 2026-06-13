class Solution {
    String[] map;
    String digits;
    StringBuilder strB;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        this.map=new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        this.digits=digits;
        this.strB=new StringBuilder();
        this.res=new ArrayList<>();
        if(digits==null || digits.isEmpty()) return res;
        dfs(0);
        return res;
    }

    private void dfs(int idx){
        if(idx==digits.length()){
            res.add(strB.toString());
            return; 
        }
        char[] cArr=map[digits.charAt(idx)-'0'-1].toCharArray();
        for(char c: cArr){
            strB.append(c);
            dfs(idx+1);
            strB.deleteCharAt(strB.length()-1);
        }

    }
}
