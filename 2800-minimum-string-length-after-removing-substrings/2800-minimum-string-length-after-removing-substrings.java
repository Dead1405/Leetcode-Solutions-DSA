class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            switch(c){
                case 'B':
                    if(stack.peek() == 'A'){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                    break;
                case 'D':
                    if(stack.peek() == 'C'){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                    break;
                default:
                    stack.push(c);
                
            }
        }
        return stack.size();
    }
}