class Solution {
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            if(Character.toUpperCase(s.charAt(l))!=Character.toUpperCase(s.charAt(r))){
                System.out.println(s.charAt(l));
                System.out.println(s.charAt(r));
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
