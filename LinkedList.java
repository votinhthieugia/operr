
public class LinkedList {
	public class Node {
		public int value;
		public Node prev;
		
		public Node(int value) {
			this.value = value;
			prev = null;
		}
	}
	
	Node tail;
	
	public LinkedList() {
		tail = null;
	}
	
	public LinkedList(int firstInt) {
		tail = new Node(firstInt);
	}
	
	public void addElement(int value) {
		if (tail == null) {
			tail = new Node(value);
		} else {
			Node node = new Node(value);
			node.prev = tail;
			tail = node;
		}
	}
	
	public void removeTailElement() {
		Node node = tail;
		tail = node.prev;
		node.prev = null;
	}
	
	public void removeAllElementsGreaterThan(int value) {
		Node node = tail;
		Node goodTailNode = null;
		
		while (node != null) {
			if (node.value > value) {
				if (goodTailNode == null) {
					node = node.prev;
					tail.prev = null;
					tail = node;
				} else {
					goodTailNode.prev = node.prev;
					node.prev = null;
					node = goodTailNode.prev;
				}
			} else {
				goodTailNode = node;
				node = node.prev;
			}
		}
	}
	
	public void print() {
		System.out.println("Linked list:");
		Node node = tail;
		
		while (node != null) {
			System.out.println(node.value);
			node = node.prev;
		}
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addElement(1);
		list.addElement(2);
		list.addElement(4);
		list.addElement(3);
		list.addElement(5);
		list.print();
		
		list.removeTailElement();
		list.print();
		
		list.removeAllElementsGreaterThan(3);
		list.print();
	}
}
