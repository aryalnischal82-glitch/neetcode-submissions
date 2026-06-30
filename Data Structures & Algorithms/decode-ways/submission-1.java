class Solution {
    Map<Integer,Integer> cache;
    String s;
    public int numDecodings(String s) {
        this.cache=new HashMap<>();
        this.s=s;
        return dfs(0);
    }

    private int dfs(int idx){
        if(cache.containsKey(idx)) return cache.get(idx);
        if(idx>=s.length()) return 1;
        if(s.charAt(idx)-'0'==0) return 0;
        int val=0;
        val+=dfs(idx+1);
        if(idx+1<s.length()){
            int twoDigit=Integer.parseInt(s.substring(idx,idx+2));
            if(twoDigit>=10 && twoDigit<=26) val+=dfs(idx+2);
        }

        cache.put(idx,val);
        return val;
    }
}


