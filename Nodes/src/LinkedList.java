
public class LinkedList {

	public static void main(String args[]) {

		LinkedList obj1 = new LinkedList();
		obj1.insert(1);

		obj1.insert(2);
		obj1.insert(3);
		obj1.insert(4);
		obj1.insert(5);
		obj1.print();
		obj1.search(obj1.head, 9);

		System.out.println("Recursive search");
		obj1.searchRecursive(obj1.head, 3);

	}

	private Node head;

	public LinkedList() {
		head = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null)
			head = newNode;

		else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;

		}

	}

	// iterative
	public boolean search(Node h, int data) {
		Node curr = h;
		while (curr.next != null) {
			if (curr.data == data) {
				System.out.print("true");
				return true;
			}
			curr = curr.next;
		}
		System.out.print("false");
		return false;
	}

	// recursive
	public void searchRecursive(Node h, int data) {
		if (h == null) {
			System.out.println("not found");
			return;
		}
		if (h.data == data) {
			System.out.println("Found " + data);
			return;
		} else {
			searchRecursive(h.next, data);
		}

	}

	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}

	}
}
