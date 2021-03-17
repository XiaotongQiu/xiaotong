//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 245 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 找到重复子树：
        // 1. 知道以我为根结点的子树长什么样
        // 2. 知道别人为根结点的子树长什么样
        // 3. 用序列化字符串表达子树
        tranverse(root);
        return res;
    }

    public StringBuilder tranverse(TreeNode root) {
        if (root == null) {
            return new StringBuilder(1).append("#");
        }
        StringBuilder l = tranverse(root.left);
        StringBuilder r = tranverse(root.right);
        l.append(",")
                .append(r.toString()).append(",")
                .append(root.val);

        String subTree = l.toString();
        int cnt = memo.getOrDefault(subTree, 0);
        if (cnt == 1) {
            res.add(root);
        }
        memo.put(subTree, cnt + 1);

        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
