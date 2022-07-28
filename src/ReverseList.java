public class ReverseList {

    /**
     * 剑指 Offer 24. 反转链表
     * <p>
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */

    /**
     * 迭代 双指针
     */
    public ListNode solution(ListNode head) {
        //初始化pre,cur分别指向null和头节点
        ListNode pre = null,cur = head,next = null;
        while(cur != null){
            //next暂存后记节点
            next = cur.next;
            //修改引用指向，使cur指向pre
            cur.next = pre;
            //pre暂存当前cur，即使pre指针后移
            pre = cur;
            //使cur指针后移，直到cur遍历完整个链表
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     *
     *
     * 终止条件：当 cur 为空，则返回尾节点 pre （即反转链表的头节点）；
     * 递归后继节点，记录返回值（即反转链表的头节点）为 res ；
     * 修改当前节点 cur 引用指向前驱节点 pre ；
     * 返回反转链表的头节点 res ；
     */
    public ListNode reverseList(ListNode head) {
        return recur(head,null);
    }

    ListNode recur(ListNode cur,ListNode pre){
        if(cur == null){
            return pre;
        }
        ListNode tmp = recur(cur.next,cur);
        cur.next = pre;
        return tmp;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
