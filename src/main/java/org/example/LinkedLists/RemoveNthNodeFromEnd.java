package org.example.LinkedLists;

/**
 * Basic Problem Concept
 *       Remove the nth node from the end of the linked list.
 *
 *       This method works by using two pointers to traverse the linked list. The fastPointer moves n + 1 nodes ahead of the slowPointer,
 *       then both pointers move forward at the same pace until the fastPointer reaches the end of the list.
 *       At this point, the slowPointer is pointing to the node that precedes the nth node from the end,
 *       so we can remove that node by updating the next field of the slowPointer.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Key Takeaways
 *      LinkedLists do not know size of lists so must find how big list is
 *      Create two pointer (slow & fast) fast loops over list quicker to return length of list
 */


public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Create temp head to be able to reference head without having to modify directly
        ListNode tempHead = new ListNode(0);
        //Set next field to head node
        tempHead.next = head;

        ListNode slowPointer = tempHead;
        ListNode fastPointer = tempHead;

        //traverse list to n position + 1
        for (int i = 1; i <= n + 1; i++) {
            //move the fastPointer one node forward by assigning value of its next field to itself.
            fastPointer = fastPointer.next;
        }

        //while fastPointer is not at end of list
        while (fastPointer != null) {
            //move both slowPointer and fastPointer one node forward by
            //assigning value of their next field to themselves.
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        //sets the next field of slowPointer to the next field of the next field of slowPointer
        //effectively removes the next node of slowPointer from the list.
        slowPointer.next = slowPointer.next.next;

        //the next field of tempHead, which is the original head node
        return tempHead.next;
    }

}
