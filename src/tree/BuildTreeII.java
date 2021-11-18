package tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeII {
    private Map<Integer, Integer> map;
    private int[] inorder;
    private int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 0){
            return null;
        }
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }

        this.inorder = inorder;
        this.postorder = postorder;
        return helper(0, len - 1, 0, len - 1);
    }

    private TreeNode helper(int postStart, int postEnd, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexAtInorder = getRootIdx(rootVal);

        int leftLen = rootIndexAtInorder - inStart;

        root.left = helper( postStart, postStart + leftLen - 1,  inStart, rootIndexAtInorder - 1);
        root.right = helper( postStart + leftLen, postEnd - 1, rootIndexAtInorder  + 1, inEnd);


        return root;
    }

    private int getRootIdx(int num){
        return map.get(num);
    }
}
