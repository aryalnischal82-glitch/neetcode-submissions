class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> needMap=new HashMap<>();
        Map<Character,Integer> haveMap=new HashMap<>();
        for(char c: t.toCharArray()){
            needMap.put(c,needMap.getOrDefault(c,0)+1);
        }
        int need=needMap.size();
        int have=0;
        int resLen=Integer.MAX_VALUE;
        int resIdx=-1;
        int l=0;
        for(int r=0;r<s.length();r++){
            char curr=s.charAt(r);
            haveMap.putIfAbsent(curr,0);
            haveMap.put(curr,haveMap.get(curr)+1);
            if(needMap.containsKey(curr) && needMap.get(curr)==haveMap.get(curr)){
                have++;
            }
            while(have==need){
                int currWindowSize=r-l+1;
                if(resLen>currWindowSize){
                    resLen=currWindowSize;
                    resIdx=l;
                }
                // begin shrinking 
                char shrinkChar=s.charAt(l);
                haveMap.put(shrinkChar,haveMap.get(shrinkChar)-1);
                if(needMap.containsKey(shrinkChar) && haveMap.get(shrinkChar)<needMap.get(shrinkChar)){
                    have--;
                }
                l++;
            }
        }
        return (resIdx==-1)? "": s.substring(resIdx,resIdx+resLen);
    }
}
