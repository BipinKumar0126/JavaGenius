package dataStructures.linkedlist;


import dataStructures.models.ListNode;
import dataStructures.utils.Util;
/**
 * 
 * @author rohitmishra
 * @link https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 */
public class RemoveDuplicatesFromSortedLinkedList {
	public static void main(String[] args) {
    	ListNode head;
        
        /* Constructed Linked List is 1->2->3->4->5->6->7->8->null */
    	head = new ListNode(1);
    	head.next = new ListNode(1);
    	head.next.next = new ListNode(2);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(4);
    	head.next.next.next.next.next = new ListNode(6);
    	head.next.next.next.next.next.next = new ListNode(7);
    	head.next.next.next.next.next.next.next = new ListNode(7);

    	Util.printLinkedList(head);
    	ListNode modifiedListHead = removeDuplicates(head);
    	Util.printLinkedList(modifiedListHead);
    	
	}

	private static ListNode removeDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode curr = head;
		
		while(curr != null && curr.next != null) {
			if(curr.val == curr.next.val) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		
		return head;
		
	}
}
