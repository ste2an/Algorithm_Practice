package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class TreeZigzagTraversal {

    public static void main(String[] args) {

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        int level = 0;
        // even from left to right, odd from right to left
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while( !queue.isEmpty() ){
            int sz = queue.size();
            List<Integer> sameLevel = new ArrayList<>();

            for(int i = 0; i < sz; i ++){
                TreeNode tmp = queue.poll();

                if(level % 2 == 0){
                    sameLevel.add(tmp.val);
                }else{
                    sameLevel.add(0, tmp.val);
                }

                if( tmp.left != null ){
                    queue.add(tmp.left);
                }

                if( tmp.right != null ){
                    queue.add(tmp.right);
                }
            }
            res.add(sameLevel);
            level ++;
        }
        return res;
    }
}
