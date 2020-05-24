# 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
# 
#  示例： 
# 
#  输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
#  
#  Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        result_temp = ListNode(-1)
        result= result_temp
        while l1 and l2:
            if l1.val <= l2.val:
                result_temp.next = l1
                l1 = l1.next
            else:
                result_temp.next = l2
                l2 = l2.next
            result_temp = result_temp.next
        if l1:
            result_temp.next = l1
        if l2:
            result_temp.next = l2
        return result.next


# leetcode submit region end(Prohibit modification and deletion)