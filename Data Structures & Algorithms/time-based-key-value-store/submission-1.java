class TimeMap {

    HashMap<String, TreeMap<Integer, String>> hm;
    public TimeMap() {
        hm = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            TreeMap<Integer, String> mp = hm.get(key);
            hm.get(key).put(timestamp, value);
        }else{
            TreeMap<Integer, String> tm = new TreeMap();
            tm.put(timestamp, value);
            hm.put(key, tm);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }

       // TreeMap<Integer, String> mp = hm.get(key);

        List<Map.Entry<Integer, String>> mapList = new ArrayList<>(hm.get(key).entrySet());
        int i=0, j=mapList.size()-1;
        String res = "" ;
        while(i<=j){

            int mid = i + (j-i)/2;
            Map.Entry<Integer, String> mp = mapList.get(mid);

            if(mp.getKey() == timestamp){
                return mp.getValue();
            }else if(mp.getKey() > timestamp){
                j=mid-1;
            }else{
                res = mp.getValue();
                i=mid+1;  
            }
        }
        return res;
    }
}
