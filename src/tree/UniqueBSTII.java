package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {

    public static void main(String[] args) {
        UniqueBSTII uniqueBST = new UniqueBSTII();
        List<TreeNode> res = uniqueBST.findAllUniqueBST(3);
        for(TreeNode tree : res){
            TreeNode.printTree(tree);
            System.out.println("---------");
        }


    }

    public List<TreeNode> findAllUniqueBST(int n){
        if(n == 0){
            return null;
        }

        return buildBST(1, n);
    }

    /* 以 i 为根节点：
    左子树为 （l, i - 1) ---> recursive 以 j 为节点，左（l， j-1），右：（j+1,i-1） --->
    右子树为 （i + 1, r) ---> recursive 以 j 为节点，左（i + 1， j-1），右：（j+1, r） --->
    有两个出口： 第一是建立树 加入list，第二个是 不合法 把null 加入list
    * */
    private List<TreeNode> buildBST(int l, int r){
        List<TreeNode> list = new ArrayList<>();
        if(l > r){
            list.add(null);
            return list;
        }

        for(int i = l; i <= r; i ++){
            // 以 i 为节点，构建左右子树集合，如果不合法即加入空集

            // TreeNode root = new TreeNode(i);
            // 在这里建立根节点会导致所有的左右不同的子树都连到了一个根节点上
            List<TreeNode> L_child = buildBST(l, i - 1);
            List<TreeNode> R_child = buildBST(i + 1, r);

            for(TreeNode L : L_child){
                for(TreeNode R : R_child){
                    TreeNode root = new TreeNode(i);
                    root.left = L;
                    root.right = R;
                    list.add(root);
                }
            }
        }
        return list;
    }


}
