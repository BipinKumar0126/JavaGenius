package dataStructures.linkedlist;

import dataStructures.models.ListNode;
import dataStructures.utils.Util;

/**
 * 
 * @link https://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 */
public class DeleteAlternateNodes {
	public static void main(String[] args) {
    	ListNode head;
        
        /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
    	head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	head.next.next.next.next.next = new ListNode(6);
    	head.next.next.next.next.next.next = new ListNode(7);
    	head.next.next.next.next.next.next.next = new ListNode(8);
    	
    	deleteAlternateNodes(head);
    	Util.printLinkedList(head);
	}

	private static void deleteAlternateNodes(ListNode head) {
		if(head == null || head.next == null)
			return;
		deleteAlternateNodes(head.next.next);
		head.next = head.next.next;
	}
	
}
