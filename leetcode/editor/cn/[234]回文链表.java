//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 891 👎 0


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
    public ListNode reverseListNode(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return true;
        }

        // 快慢双指针，找到链表中心点
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { // 链表长度为偶数
            slow = slow.next;
        }

        // 反转后半段链表
        ListNode r = reverseListNode(slow);
        ListNode l = head;

        // 从两头向中间遍历，check是否前后一致
        while (r != null) {
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
