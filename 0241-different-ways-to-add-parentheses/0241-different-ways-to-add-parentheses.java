class Solution {
    public List<Integer> comboMaker(String exp, HashMap<String, List<Integer>> memo){
        if(memo.containsKey(exp)) return memo.get(exp);
        else{
            List<Integer> combos = new ArrayList<Integer>();
            for(int i = 0; i < exp.length(); i ++){
                char ch = exp.charAt(i);
                if( ch == '-' || ch == '+' || ch == '*'){
                    String s1 = exp.substring(0,i);
                    String s2 = exp.substring(i+1);
                    List<Integer> l1 = diffWaysToCompute(s1);
                    List<Integer> l2 = diffWaysToCompute(s2);
                    for(int j : l1){
                        for(int k : l2){
                            if(ch == '-') combos.add(j - k);
                            else if(ch == '+') combos.add(j + k);
                            else if(ch == '*') combos.add(j * k);
                        }
                    }
                }    
            }
            //if single number only left
            if(combos.size() == 0) combos.add(Integer.parseInt(exp));
            memo.put(exp, combos);
            return combos;    
            
        }
    }
    public List<Integer> diffWaysToCompute(String exp) {
        // //first lets try it with simple backtracking
        // List<Integer> combos = new ArrayList<Integer>();
        // for(int i = 0; i < exp.length(); i ++){
        //     char ch = exp.charAt(i);
        //     if( ch == '-' || ch == '+' || ch == '*'){
        //         String s1 = exp.substring(0,i);
        //         String s2 = exp.substring(i+1);
        //         List<Integer> l1 = diffWaysToCompute(s1);
        //         List<Integer> l2 = diffWaysToCompute(s2);
        //         for(int j : l1){
        //             for(int k : l2){
        //                 if(ch == '-') combos.add(j - k);
        //                 else if(ch == '+') combos.add(j + k);
        //                 else if(ch == '*') combos.add(j * k);
        //             }
        //         }
        //     }
        // }
        // if(combos.size() == 0) combos.add(Integer.parseInt(exp));
        // return combos;
        

        // now lets try memorization
        // we will use a map of <String, List> to store the ans to diff computations
        //first make a map for memorization
        HashMap<String, List<Integer>> memo = new HashMap<>();
        comboMaker(exp, memo);
        return memo.get(exp);
    }
}