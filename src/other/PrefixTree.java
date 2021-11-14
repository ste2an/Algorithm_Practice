package other;

public class PrefixTree {

    private PrefixTree[] tree;
    private boolean isEnd;

    public PrefixTree() {
        this.tree = new PrefixTree[26];
        this.isEnd = false;
    }

    public void insert(String word){
        PrefixTree node = this;

        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(node.tree[idx] == null){
                node.tree[idx] = new PrefixTree();
                // node.left = new node();
            }
            node = node.tree[idx];
            // node = node.left;
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        PrefixTree node = this;

        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(node.tree[idx] == null){
                return false;
            }
            node = node.tree[idx];
        }
        return node.isEnd;
    }

    public boolean searchPrefix(String word){
        PrefixTree node = this;

        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(node.tree[idx] == null){
                return false;
            }
            node = node.tree[idx];
        }
        return true;
    }
}
