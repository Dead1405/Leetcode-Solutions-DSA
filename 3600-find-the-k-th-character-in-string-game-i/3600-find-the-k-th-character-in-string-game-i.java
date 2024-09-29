class Solution {
    public char kthCharacter(int k) {
        if (k == 1) return 'a';
        int parent =(int) (Math.log(k) / Math.log(2.00001));
        parent =k - (1<<parent);
        System.out.println(Math.log(k)/Math.log(2.00001));
        char ch = kthCharacter(parent);


        if(ch == 'z') return 'a';
        else return (char)(ch + 1);
    }
}