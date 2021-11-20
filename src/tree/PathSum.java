package tree;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 思考 只有一个节点的时候怎么判断
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == targetSum;

        // 然后扩散到普通情况
        boolean l = hasPathSum(root.left, targetSum - root.val);
        boolean r = hasPathSum(root.right, targetSum - root.val);
        return l || r;
    }
}
