class Solution {
    List<String> result = new ArrayList();
    public List<String> generateParenthesis(int n) {
        generateParenthesisUtil(n, 0, 0, new StringBuilder());
        return result;
    }

    void generateParenthesisUtil(int n, int open, int close, StringBuilder s){
        if(s.length() == 2*n){
            result.add(s.toString());
            return;
        }

        if(open<n){
            generateParenthesisUtil(n, open+1, close, s.append("("));
            s.deleteCharAt(s.length()-1);
        }
        if(close<open){
            generateParenthesisUtil(n, open, close+1, s.append(")"));
            s.deleteCharAt(s.length()-1);
        }
    }
}
