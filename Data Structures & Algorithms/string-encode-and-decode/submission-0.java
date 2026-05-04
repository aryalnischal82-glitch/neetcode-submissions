class Solution {

    public String encode(List<String> strs) {
        StringBuilder res=new StringBuilder();
        for(String str: strs){
            res.append(String.valueOf(str.length())).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        int j=0;
        List<String> res=new ArrayList<>();
        while(j<str.length()){
            if(str.charAt(j)=='#'){
                int currLength=Integer.valueOf(str.substring(i,j));
                String currWord=str.substring(j+1,j+1+currLength);
                res.add(currWord);
                i=j+1+currLength;
                j=i;
            }
            j++;
        }
        return res;
    }
}
