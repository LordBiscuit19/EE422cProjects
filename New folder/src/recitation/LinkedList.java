package recitation;

public class LinkedList<T> {
	private LinkedListNode<T> head;
	
	public LinkedList(LinkedListNode<T> param) {
		head = param;
	}
	
	public void insert(LinkedListNode<T> node) {
		if (head == null) {
			head = node;
		}
		else {
			node.setNext(head);
			head = node;
		}
	}
	
	public String printList() {
		LinkedListNode<T> temp = head;
		String print = "";
		while(temp != null) {
			print += temp.toString() + "\n";
			
			temp = temp.getNext();
		}
		return print;
	}
	
	public void remove() {
		if (head != null) {
			LinkedListNode<T> temp = head;
			head = head.getNext();
			temp.setNext(null);
		}
	}
	
	public void reverse() {
		LinkedListNode<T> prev = null;
		LinkedListNode<T> cur = head;
		LinkedListNode<T> next = head.getNext();
		
		while (next != null) {
			if(prev == null) {
				cur.setNext(prev);
			}
			prev = cur;
			cur = next;
			if(next != null) {
				next = next.getNext();
			}
			cur.setNext(prev);
			
		}
		head = cur;
	}
	
}
