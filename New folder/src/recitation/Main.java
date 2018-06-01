package recitation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car("car1", 50);
		Car car2 = new Car("car2", 100);
		Car car3 = new Car("car3", 150);
		
		LinkedListNode<Car> node1 = new LinkedListNode<Car>(car1);
		LinkedListNode<Car> node2 = new LinkedListNode<Car>(car2);
		LinkedListNode<Car> node3 = new LinkedListNode<Car>(car3);
		node1.setNext(node2);
		node2.setNext(node3);
		LinkedList<Car> list = new LinkedList<Car>(node1);
		System.out.println(list.printList());
		list.reverse();
		System.out.println(list.printList());
	}

}