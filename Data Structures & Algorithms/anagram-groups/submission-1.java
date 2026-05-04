class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str: strs){
            char[] cArr=new char[26];
            for(char c: str.toCharArray()){
                cArr[c-'a']++;
            }
            String freqStr=String.valueOf(cArr);
            map.putIfAbsent(freqStr,new ArrayList<>());
            map.get(freqStr).add(str);
        }
        List<List<String>> res=new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
