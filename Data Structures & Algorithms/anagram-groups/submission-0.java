class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 Map<String, List<String>> map = new HashMap<>();
    
     for(String str : strs){
        char[] s = str.toCharArray();
        int[] count = new int[26];
        for(char c : s){
            count[c - 'a']++;
        }
        String st = Arrays.toString(count);
        if(map.containsKey(st)){
            map.get(st).add(str);
        }else{
            ArrayList<String> arr = new ArrayList();
            arr.add(str);
            map.put(st, arr);
        }
     }

     return new ArrayList<>(map.values());
    }
}
