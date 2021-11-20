package tree;
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum,res, new ArrayList<Integer>());
        return res;

    }

    public void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);

        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                res.add(new ArrayList<>(path));
            }
        }

        //System.out.println(path);

        dfs(root.left, targetSum - root.val, res, path);
        dfs(root.right, targetSum - root.val, res, path);

        path.remove(path.size() - 1);
    }
}
