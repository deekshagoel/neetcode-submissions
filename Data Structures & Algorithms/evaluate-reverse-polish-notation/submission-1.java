class Solution {
    public int evalRPN(String[] tokens) {
        
        //int n = tokens.length();

        Stack<String> stack = new Stack();
        for(String t : tokens){
            if(isNum(t)){
                stack.push(t);
            }else{
                String a = stack.pop();
               String b = stack.pop();
                String c = doMath(b, a, t);
                stack.push(c);
            }
        }
       return Integer.valueOf(stack.peek());
    }

    boolean isNum(String s){
        try{    
            int a = Integer.parseInt(s);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    String doMath(String a , String b, String t){
        int i = Integer.parseInt(a);
        int j = Integer.parseInt(b);

                System.out.println(a +" "+b+" "+t);

        int res = 0;
        switch(t){
            case "+" : res= i+j;
            break;
            case "*" : res= i*j;
            break;
            case "-" : res= i-j;
            break;
            case "/" : res= i/j;
            break;
        }

        System.out.println(res);
        return String.valueOf(res);
    }
}
