//A node contains part data and a node
//The class contains  constructor that sets the data and the node to which it points to
//a get data method, get next method, set data and set next method
public class Node {

//	public static void main(String args[]) {
//		Node x = new Node(1, null);
//		Node y = new Node(2, x);
//		System.out.println(y.getData());
//		System.out.println(y.getNext().getData());
//	}

	public int data;
	public Node next;

	Node(int data) {
		this.data = data;

	}

}
