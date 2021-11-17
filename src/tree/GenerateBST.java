package tree;

public class GenerateBST {

    public static void main(String[] args) {
        GenerateBST generateBST = new GenerateBST();
        TreeNode root = generateBST.generateBST(5, 10);
        TreeNode.printTree(root);
    }

    public TreeNode generateBST(int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(mid);
        root.left = generateBST(left, mid - 1);
        root.right = generateBST(mid  + 1, right);
        return root;
    }
}
