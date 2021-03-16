//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 中序遍历的root左边数组是左子树，右边数组是右子树
        // 后序遍历的root是数据最后一个元素
        return build(inorder, 0, inorder.length -1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build (int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        // 找到左右子树对应数组
        int idx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                idx = i;
            }
        }

        int leftSize = idx - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = build(inorder, inStart, idx-1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, idx + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
