class Solution {
    String s;
    public int countSubstrings(String s) {
        this.s=s;
        int l=s.length();
        int res=0;
        for(int i=0;i<l;i++){
            res+=isPalindrome(i,i);
            res+=isPalindrome(i,i+1);
        }
        return res;
    }

    private int isPalindrome(int l, int r){
        int count=0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }

    
}
