package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    // level traversal with Queue

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int sz = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < sz; i ++){
                TreeNode tmp = queue.poll();
                level.add(tmp.val);

                if(tmp.left != null){
                    queue.add(tmp.left);
                }

                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
