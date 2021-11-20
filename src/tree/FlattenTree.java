package tree;

public class FlattenTree {

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        flatten(root.left);
        // deal with left first then right
        flatten(root.right);

        //at this moment, the left and right child is processed,
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        while(root.right != null){
            root = root.right;
        }
        root.right = right;
    }
}
