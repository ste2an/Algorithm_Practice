package tree;

public class PathSumMax {
    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        MaxSidePath(root);
        return res;
    }


    public int MaxSidePath(TreeNode node){
        // 该方法目的是求单边最大和

        if(node == null) return 0;

        int maxLeft = MaxSidePath(node.left);
        if(maxLeft < 0) maxLeft = 0;

        int maxRight = MaxSidePath(node.right);
        if(maxRight < 0) maxRight = 0;

        int leftPath = maxLeft + node.val;
        int rightPath = maxRight + node.val;

        int totalPath = maxLeft + maxRight + node.val;

        res = Math.max(totalPath, res);
        /* 如果子节点值为负值，会返回0，所以一定是totalPath是最大值，只需要比较每个节点的totalPath
        如：
         -2
         / \
       -1  -4
       对于-2节点，左右都返回0，即不考虑左右子节点，所以totalPath = -2，但该totalPath在递归时，已经计算过-1，和 -4的totalPath，并且每一轮返回了 max的，所以计算顺序为：
       max(-infinite, -1) = -1  left child node
       max(-1, -4) = -1  right child node
       max(-1,-2) = -1 root node
        */
        return Math.max(leftPath, rightPath);
    }
}
