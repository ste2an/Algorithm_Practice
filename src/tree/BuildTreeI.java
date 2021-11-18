package tree;

public class BuildTreeI {
    // Construct Binary Tree from Preorder and Inorder Traversal
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        return helper(0, preorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode helper(int pre_start, int pre_end, int in_start, int in_end){
        if(pre_start > pre_end){
            return null;
        }

        if(in_start > in_end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre_start]);
        int idxAtInorder = getRootIndexAtInorder(preorder[pre_start]);
        // 左边就是左子树，右边就是右子树
        int leftLen = idxAtInorder - in_start;

        root.left  = helper(pre_start + 1, pre_start + leftLen, in_start, idxAtInorder - 1);
        root.right = helper(pre_start + leftLen + 1, pre_end, idxAtInorder + 1, in_end);

        return root;
    }

    public int getRootIndexAtInorder(int num){
        for(int i = 0; i < inorder.length; i ++){
            if(num == inorder[i]){
                return i;
            }
        }
        return -1;
    }
}
