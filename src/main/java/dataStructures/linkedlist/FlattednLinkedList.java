package dataStructures.linkedlist;

import dataStructures.models.ListNode;
import dataStructures.models.ListNodeWithTwoChild;
import dataStructures.utils.Util;

public class FlattednLinkedList {
	public static void main(String[] args) {
		ListNodeWithTwoChild head = new ListNodeWithTwoChild(5);
		head.next = new ListNodeWithTwoChild(10);
		head.next.next = new ListNodeWithTwoChild(19);
		head.next.next.next = new ListNodeWithTwoChild(28);
		
		head.down = new ListNode(7);
		head.down.next = new ListNode(8);
		head.down.next.next = new ListNode(30);
		
		head.next.down = new ListNode(20);
		
		head.next.next.down = new ListNode(0);
		
		head.next.next.next.down = new ListNode(22);
		head.next.next.next.down.next = new ListNode(50);
		
		head.next.next.next.next.down = new ListNode(35);
		head.next.next.next.next.down.next = new ListNode(40);
		head.next.next.next.next.down.next.next = new ListNode(45);
		
		
		flattenList(head);
		Util.printLinkedList(head);
	}

	private static void flattenList(ListNodeWithTwoChild head) {
		if(head == null)
			return;
		
		
	}
}
