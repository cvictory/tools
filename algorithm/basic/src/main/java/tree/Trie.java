package tree;

/**
 * @author cvictory ON 2019-06-02
 */
public class Trie {
    private Node rootNode;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        rootNode = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] wordChar = word.toCharArray();
        Node parentNode = rootNode;
        StringBuilder temp = new StringBuilder();
        for (char w : wordChar) {
            temp.append(w);
            Node curNode = parentNode.children[w - 'a'];
            if (curNode == null) {
                curNode = new Node(temp.toString(), false);
                parentNode.children[w - 'a'] = curNode;
            }
            parentNode = curNode;
        }
        parentNode.isData = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node parentNode = rootNode;
        for (char w : word.toCharArray()) {
            Node curNode = parentNode.children[w - 'a'];
            if (curNode == null) {
                return false;
            }
            parentNode = curNode;
        }
        if (parentNode.isData) {
            return true;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node parentNode = rootNode;
        for (char w : prefix.toCharArray()) {
            Node curNode = parentNode.children[w - 'a'];
            if (curNode == null) {
                return false;
            }
            parentNode = curNode;
        }
        return true;
    }

    public static class Node {
        String val;
        Node[] children = new Node[26];
        boolean isData;

        public Node(String val, boolean isData) {
            this.val = val;
            this.isData = isData;
        }

        public Node() {
        }
    }
}
