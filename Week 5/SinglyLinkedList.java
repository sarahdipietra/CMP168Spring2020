package com.mycompany.list;

public class SinglyLinkedList {
	private class ListNode {
		int data;
		ListNode next;
		
		public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
		}
	}
	
	private ListNode head;
	
	public void append(int data) {
		if (head == null) {
			head = new ListNode(data, null);
		}
		else {
			ListNode curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = new ListNode(data, null);
		}
	}
	
	public void show() {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.data +  " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public void insertionSort() { //A naive algorithm 
		ListNode dummy = new ListNode(-1, head);
		ListNode iter = head;
		
		while (iter != null && iter.next != null) {
			if (iter.data > iter.next.data) {
				ListNode target = iter.next, prev = dummy;
				while (prev.next.data < target.data ) {
					prev = prev.next;
				}
				ListNode temp = prev.next;
				prev.next = target;
				iter.next = target.next;
				target.next = temp;
			}
			else {
				 iter = iter.next;
			}
		}
		head = dummy.next;
	}
	
	public void mergeSort() {
		head = mergeSort(head);
	}
	
	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode preSlow = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			preSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		preSlow.next = null;
		return merge(mergeSort(head), mergeSort(slow));
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1, null);
		ListNode curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				curr.next = l1;
				l1 = l1.next;
			}
			else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 != null ?l1 : l2;
		return dummy.next;
	}
}
