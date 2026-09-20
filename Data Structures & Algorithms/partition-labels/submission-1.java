class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList();
        List<String> result = new ArrayList();

        HashMap<Character, Integer> hm = new HashMap();
        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), i);
        }
        int size = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            size++;
            end = Math.max(end, hm.get(s.charAt(i)));

            if(i==end){
                res.add(size);
                result.add(s.substring(i>0 ? i-size+1 : i, i));
                size = 0;
            }
        }
        result.stream().forEach(i -> System.out.println(i));
        return res;
    }
}
