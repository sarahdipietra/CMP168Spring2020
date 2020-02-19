
public class Main {
	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insertAtFront(16);
		myList.insertAtFront(24);
		myList.insertAtFront(18);
		myList.insertAtFront(20);
		myList.show();
		myList.reverse();
		myList.show();
	}
}
