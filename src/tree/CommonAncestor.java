package tree;

import java.util.*;

public class CommonAncestor {

    private Map<TreeNode, TreeNode> map;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        map = new HashMap<>();
        map.put(root, null);
        traversalTree(root);

        Set<TreeNode> ancestorOfP = new HashSet<>();

        while(p != null){
            ancestorOfP.add(p);
            p = map.get(p);
        }

        while(!ancestorOfP.contains(q)){
            q = map.get(q);
        }

        return q;
    }


    public void traversalTree(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode tmp = queue.poll();

            if(tmp.left != null){
                map.put(tmp.left, tmp);
                queue.add(tmp.left);
            }

            if(tmp.right != null){
                map.put(tmp.right, tmp);
                queue.add(tmp.right);
            }
        }
    }
}
