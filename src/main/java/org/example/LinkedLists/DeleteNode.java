package org.example.LinkedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class DeleteNode {

    public void deleteNode(ListNode node) {

        // Because given input node is not last node, so nextNode will not be null
        // assigns the value of the next node
        ListNode nextNode = node.next;
        //"overwrite" the input node with the value of the next node.
        node.val = nextNode.val;


        //The method then sets the next field of the input node to the next field of the next node.
        //This removes the next node from the linked list and connects the input node to the node after the next node.
        node.next = nextNode.next;

        //the next field of the next node to null, effectively deleting it from the linked list.
        nextNode.next = null;

    }

}
