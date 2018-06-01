package recitation;

public class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> next;
	
	public LinkedListNode(T param){
		value = param;
	}
	
	public void setNext(LinkedListNode<T> param) {
		next = param;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	public LinkedListNode<T> getNext() {
		return next;
	}
	
}
