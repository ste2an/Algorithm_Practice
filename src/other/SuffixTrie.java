package other;

import java.util.ArrayList;
import java.util.List;

public class SuffixTrie {
    Node root;
    public SuffixTrie(){
        root = new Node('\0');
    }

    public void addString(String str){
        str = str.toLowerCase();
        str += "$";
        for(int i = str.length() - 1; i >= 0; i--){
            insertString(str.substring(i));
            // get all the substring
        }
    }

    private void insertString(String str){
        Node current = root;
        for(char ch : str.toCharArray()) {
            Node child = findNode(current, ch);

            if (child == null) {
                child = new Node(ch);
                current.children.add(child);
            }
            current = child;
        }
        current.isEndChar = true;
    }

    private Node findNode(Node node, char ch){
        for(Node child : node.children){
            if(child.ch == ch){
                return child;
            }
        }
        return null;
    }

    public boolean isSubString(String str){
        Node current = root;
        for(char ch : str.toCharArray()){
            Node child = findNode(current, ch);

            if(child == null){
               return false;
            }
            current = child;
        }
        return true;
    }

    public int findNumberOfOccurrence(String str){
        Node current = root;
        for(char ch : str.toCharArray()){
            Node child = findNode(current, ch);

            if(child == null){
                return 0;
            }
            current = child;
        }

        // return all the
        return findAllTerminalCh(current);
    }

    private int findAllTerminalCh(Node node){

        int result = node.ch == '$' ?  1 : 0;
        for(Node child : node.children){
            result += findAllTerminalCh(child);
        }

        return result;
    }

}

class Node{
    public char ch;
    public boolean isEndChar;
    public List<Node> children;

    public Node(char ch){
        this.ch = ch;
        this.isEndChar = false;
        this.children = new ArrayList<>();
    }
}
