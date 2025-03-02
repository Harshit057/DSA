class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head, n):  # Removed type hints
        dummy = ListNode(0)
        dummy.next = head
        fast = slow = dummy

        # Move fast pointer n+1 steps ahead
        for _ in range(n + 1):
            fast = fast.next
        
        # Move both fast and slow pointers together
        while fast:
            fast = fast.next
            slow = slow.next
        
        # Remove the Nth node
        slow.next = slow.next.next

        return dummy.next  # Return new head
