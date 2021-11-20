package tree;

public class AddNextPointer {
    public TreeNode connect(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        // 先处理这一层，利用root 处理下一层
        if(root.left != null){
            root.left.next = root.right;
            // 连接同一个root的子节点
            if(root.next != null){
                root.right.next = root.next.left;
                //连接不同root的节点， 示例的 ⑤ --> ⑥
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }
}
