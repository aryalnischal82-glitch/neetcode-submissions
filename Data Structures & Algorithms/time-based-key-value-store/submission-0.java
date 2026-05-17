class TimeMap {
    Map<String,List<Value>> map;
    public TimeMap() {
        this.map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Value(value,timestamp));
    }
    
    public String get(String key, int timestamp) {  
        if(!map.containsKey(key)) return "";
        List<Value> vals=map.get(key);
        int l=0;
        int r=vals.size()-1;
        int resIdx=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            Value curr=vals.get(m);
            if(curr.time<=timestamp){
                resIdx=m;
                l=m+1;    
            }else{
                r=m-1;
            }
        }
        return (resIdx==-1)? "": vals.get(resIdx).val;
    }
}

class Value{
    String val;
    int time;

    public Value(String val, int time){
        this.val=val;
        this.time=time;
    }
}
