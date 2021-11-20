package tree;

public class CountTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int l = getHeight(root.left);
        int r = getHeight(root.right);

        if(l == r){
            // left tree is perfect tree
            int numOfLeft = (1 << l) - 1;
            return numOfLeft + 1 + countNodes(root.right);

        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }

    public int getHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        return 1 + getHeight(root.left);
    }
}
