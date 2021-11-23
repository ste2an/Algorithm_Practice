package tree;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return null;
        }

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        // 此时左右已经处理好了
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
