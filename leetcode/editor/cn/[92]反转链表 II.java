//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 687 👎 0


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
    ListNode n = null;
    public ListNode reverse2n(ListNode head, int right) {
        if (head == null || head.next == null || right <= 1) {
            n = head.next;
            return head;
        }
        ListNode last = reverse2n(head.next, right-1);
        head.next.next = head;
        head.next = n;

        return last;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (left == 1) {
            return reverse2n(head, right);
         }
         head.next = reverseBetween(head.next, left-1, right-1);
         return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
