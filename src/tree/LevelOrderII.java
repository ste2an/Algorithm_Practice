package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while( !queue.isEmpty() ){
            int sz = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for(int i = 0; i < sz; i ++){
                TreeNode tmp = queue.poll();
                curLevel.add(tmp.val);

                if(tmp.left != null){
                    queue.add(tmp.left);
                }

                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }

            res.add(0, curLevel);
        }
        return res;
    }
}
