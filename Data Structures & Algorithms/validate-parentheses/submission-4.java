class Solution {
    public boolean isValid(String s) {
        int n=s.length();

        int l=0, r=n-1;
        HashMap<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[',']');
       
       Stack<Character> st = new Stack();

       for(char c : s.toCharArray()){
        if(map.containsKey(c)){
            st.push(c);
        }else{
            if(st.isEmpty() || map.get(st.peek()) != c){
                return false;
            }else{
                st.pop();
            }
        }
       }
       return st.isEmpty();
    }
}
