class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] sArr=new char[26];
        char[] tArr=new char[26];
        for(char c: s.toCharArray()) sArr[c-'a']++;
        for(char c: t.toCharArray()) tArr[c-'a']++;
        return Arrays.equals(sArr,tArr);
    }
}
