//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 539 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s0 = new Stack<TreeNode>(); // s0入栈 中->左右
        Stack<TreeNode> s1 = new Stack<TreeNode>(); // s1入栈顺序和s0出栈顺序一致，中右左；s1出栈左右中

        s0.push(root);
        while (!s0.isEmpty()) {
            TreeNode cur = s0.pop();
            s1.push(cur);
            if (cur.left != null) {
                s0.push(cur.left);
            }
            if (cur.right != null) {
                s0.push(cur.right);
            }
        }

        while (!s1.isEmpty()) {
            result.add(s1.pop().val);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
