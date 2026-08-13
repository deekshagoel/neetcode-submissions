class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length())
            return false;

        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        for(int i = 0;i<a.length; i++){
            System.out.println(a[i]);
            mapA.put(a[i], mapA.getOrDefault(a[i],0)+1);
            mapB.put(b[i], mapB.getOrDefault(b[i],0)+1);
        }
        return mapA.equals(mapB);
    }
}
