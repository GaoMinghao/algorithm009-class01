//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 347 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trieNode = root;
        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (!trieNode.containsKey(currentChar)) {
                trieNode.put(currentChar, new TrieNode());
            }
            trieNode = trieNode.get(currentChar);
        }
        trieNode.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = searchPrefix(prefix);
        return trieNode != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char curLetter = word.charAt(i);
            if(node.containsKey(curLetter)) {
                node = node.get(curLetter);
            }else {
                return null;
            }
        }
        return node;
    }
}
class TrieNode{
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    public void put(char ch, TrieNode  node){
        links[ch - 'a'] = node;
    }
    public void  setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
