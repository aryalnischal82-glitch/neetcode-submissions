class Solution {
    int[] chars;
    public int characterReplacement(String s, int k) {
        this.chars=new int[26];
        int l=0;
        int maxFreq=0;
        int res=0;
        for(int r=0;r<s.length();r++){
            chars[s.charAt(r)-'A']+=1;
            maxFreq=Math.max(maxFreq,chars[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq>k){
                chars[s.charAt(l)-'A']-=1;
                maxFreq=calcMaxFreq();
                l++;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }

    private int calcMaxFreq(){
        int maxFreq=0;
        for(int i=0;i<26;i++){
            maxFreq=Math.max(maxFreq,chars[i]);
        }
        return maxFreq;
    }
}