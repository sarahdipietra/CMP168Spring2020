
public class SinglyLinkedList {
	private class ListNode {
		int data;
		ListNode next;
		
		public ListNode (int data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
		private ListNode head; 
		
		public void insertAtFront(int data) {
			head = new ListNode(data, head);
		}
		
		public void show() {
			ListNode cur = head; 
			while(cur != null) {
				System.out.print(cur.data + " ");
				cur = cur.next;
			}
			System.out.println();
		}
		
		public void reverse() {
			ListNode dummy = new ListNode(-1, null);
			ListNode cur = head; while (cur != null) {
				ListNode next = cur.next;
				cur.next = dummy.next;
				dummy.next = cur;
				cur = next; 
			}
			head = dummy.next;
		}
	}
