class Trie {
    boolean end = false;
    Trie[] children = new Trie[26];

    public void insert(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null) {
                temp.children[word.charAt(i) - 'a'] = new Trie();
            } 
            temp = temp.children[word.charAt(i) - 'a'];
            
        }
        temp.end = true;
    }

    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null)
                return false;

            temp = temp.children[word.charAt(i) - 'a'];

        }
        return temp.end;
    }

    public boolean startsWith(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            if (temp.children[word.charAt(i) - 'a'] == null)
                return false;
            else {
                temp = temp.children[word.charAt(i) - 'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */