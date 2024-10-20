class Solution {
    ArrayList<String> custSplit(String s){
        ArrayList<String> tokens = new ArrayList<>();
        int open= 0;
        int front = 0, rear = 0;
        while(rear != s.length()){
            if(open == 0 && s.charAt(rear) == ','){
                tokens.add(s.substring(front, rear));
                front = rear + 1;
            }
            else if(s.charAt(rear) == '(') open++;
            else if(s.charAt(rear) == ')') open--;
            rear++;
        }
        tokens.add(s.substring(front, rear));
        return tokens;
    } 
    public boolean parseBoolExpr(String s) {
        if (s.equals("f"))
            return false;
        else if (s.equals("t"))
            return true;
        ArrayList<String> operands = custSplit(s.substring(2, s.length() - 1));
        if (s.charAt(0) == '!') {
            return !parseBoolExpr(s.substring(2, s.length() - 1));
        } else if (s.charAt(0) == '&') {
            for (String a : operands) {
                if (parseBoolExpr(a) == false)
                    return false;
            }
            return true;
        } else {
            for (String a : operands) {
                if (parseBoolExpr(a) == true)
                    return true;
            }
            return false;
        }
    }
}