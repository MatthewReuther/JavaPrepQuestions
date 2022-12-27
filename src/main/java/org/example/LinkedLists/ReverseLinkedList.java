package org.example.LinkedLists;

/**
 *
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
 *
 *  Using Iterative approach
 *      iterate through the list and update the next field of each node to point to the previous node.
 *      using three pointers: a current pointer to keep track of the current node,
 *      a prev pointer to keep track of the previous node,
 *      and a next pointer to store a reference to the next node.
 *
 *  Complexity Analysis
 *      Time Complexity
 *          The complexity of this method is O(n), where n is the number of nodes in the linked list.
 *          This is because the while loop iterates over all n nodes in the list and performs a constant amount of work on each iteration.
 *          Method's runtime will grow linearly with the size of the input
 *
 *      Space Complexity
 *          Constant space complexity of O(1). This is because it only uses a constant amount of memory,
 *          regardless of the size of the input.
 */

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        //Pointers
        //current pointer to keep track of the current node
        ListNode curr = head;

        //prev pointer to keep track of the previous node
        ListNode prev = null;

        //next pointer to keep track of the next node
        ListNode next = null;

        //while curr node is not null
        while (curr != null) {
            //Set next = to the next node in the list
            next = curr.next;

            //update curr node to point to the previous node.
            curr.next = prev;

            //Update the previous and curr points
            //update the value of prev to be current
            prev = curr;
            //update the value of curr to be next
            curr = next;
        }

        //return prev point that will point to the last node in original list
        //which is now the head of reversed list
        return prev;
    }

}
