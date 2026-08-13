class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        HashMap<Character,Character> hm = new HashMap();

        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');

        for(char c : s.toCharArray()){
            if(hm.containsKey(c)){
                if(st.isEmpty()){
                    return false;
                } else{
                    //char b = st.pop();
                    if(!(hm.get(c) == st.pop())){
                        return false;
                    }
                }
            }else{
                st.push(c);
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}
