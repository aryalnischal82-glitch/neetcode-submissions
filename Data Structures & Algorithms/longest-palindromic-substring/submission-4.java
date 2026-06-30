class Solution {
    String s;
    public String longestPalindrome(String s) {
        this.s=s;
        int max=0;
        int startIdx=-1;
        for(int i=0;i<s.length();i++){
            int oddLength=isPalindrome(i,i);
            int evenLength=isPalindrome(i,i+1);
            if(oddLength>max){
                max=oddLength;//max->3
                startIdx=i-oddLength/2;//2-3/2->1+3
            }
            if(evenLength>max){
                max=evenLength;//max->2
                startIdx=i-evenLength/2+1;//st->1
            }
        }
        return s.substring(startIdx,startIdx+max);
    }

    private int isPalindrome(int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
