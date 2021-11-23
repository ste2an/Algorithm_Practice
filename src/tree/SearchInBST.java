package tree;

import java.util.Stack;

public class SearchInBST {

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return Integer.MIN_VALUE;
        }

        Stack<TreeNode> stack = new Stack<>();
        int count = 1;
        while(!stack.isEmpty() || root != null){
            // inOrder traversal
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // System.out.println(root.val);
            if(count == k){
                return root.val;
            }
            count ++;
            root = root.right;
        }

        return Integer.MAX_VALUE;
    }
}
