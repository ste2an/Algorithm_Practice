package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode next;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTree(TreeNode root){
        if(root == null){
            System.out.println("root is null");
            return;
        }
        List<List<TreeNode>> print = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz = queue.size();
            List<TreeNode> list = new ArrayList<>();

            for(int i = 0; i < sz; i ++) {
                TreeNode tmp = queue.poll();
                list.add(tmp);

                if (tmp.left != null) {
                    queue.add(tmp.left);
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            print.add(list);
        }

        for(int i = 0; i < print.size(); i ++){
            List<TreeNode> curLevel = print.get(i);
            for(TreeNode node : curLevel){
                System.out.print(node.val + " ");
            }
            System.out.println( );
        }

    }
}
