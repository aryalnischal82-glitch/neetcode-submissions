class Solution {
    public String longestCommonPrefix(String[] strs) {
        int smallest=Integer.MAX_VALUE;
        for(String s: strs){
            smallest=Math.min(smallest,s.length());
        }
        String baseStr=strs[0];
        for(int i=0;i<smallest;i++){
            for(int j=1;j<strs.length;j++){
               if(baseStr.charAt(i)!=strs[j].charAt(i)) return baseStr.substring(0,i);
            }
        }
        return baseStr.substring(0,smallest);
    }
}