//Given a linked list, reverse the nodes of a linked list k at a time and return
// its modified list. 
//
// k is a positive integer and is less than or equal to the length of the linked
// list. If the number of nodes is not a multiple of k then left-out nodes, in the
// end, should remain as it is. 
//
// Follow up: 
//
// 
// Could you solve the problem in O(1) extra memory space? 
// You may not alter the values in the list's nodes, only nodes itself may be ch
//anged. 
// 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = [1,2,3,4,5], k = 1
//Output: [1,2,3,4,5]
// 
//
// Example 4: 
//
// 
//Input: head = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range sz. 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 931 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode nxt = null;
        while (cur != tail) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l,r;
        l = r = head;

        // 找到前k个的左右端点
        for (int i=0; i < k; i++) {
            if (r == null) {
                return head;
            }
            r = r.next;
        }

        // 反转前k个值
        ListNode last = reverse(l, r);

        // 递归反转剩下部分
        l.next = reverseKGroup(r, k);

        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
