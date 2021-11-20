package tree;

public class AddNextPointerII {
    public TreeNode connect(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode res = root;
        while(root != null){
            TreeNode dummy = new TreeNode();
            TreeNode tmp = dummy;

            while(root != null){
                if(root.left != null){
                    tmp.next = root.left;
                    tmp = tmp.next;
                    // 必须保证 root 有左、右孩子的时候才可以进行 tmp = tmp.next
                }

                if(root.right != null){
                    tmp.next = root.right;
                    tmp = tmp.next;
                }

                root = root.next;
            }
            root = dummy.next;
            // dummy.next 已经连到了 root的某个子树上
        }
        return res;
    }
}
