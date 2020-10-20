
public class BinaryTree {

	static Node root;

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		bt.TreeTraverse(root);
	}

	public BinaryTree createBinaryTree() {
		BinaryTree bt = new BinaryTree();
		bt.insert(30);
		bt.insert(5);
		bt.insert(10);
		bt.insert(-3);

		return bt;
	}

	public void insert(int item) {
		root = insertRecursive(root, item);
	}

	public Node insertRecursive(Node node, int item) {
		if (node == null) {

			return new Node(item);
		}

		if (item > node.item) {
			node.right = insertRecursive(node.right, item);
		}
		if (item < node.item) {
			node.left = insertRecursive(node.left, item);
		}

		return node;
	}

	public Node search(Node node, int item) {
		if (node.parent == null) {
			System.out.println("Empty Node");
			return null;
		}

		if (node.item == item) {
			System.out.println("Found " + item);
			return null;
		}
		if (item < node.item)
			return search(node.left, item);
		else
			return search(node.right, item);
	}

	public int findMin(Node node) {
		Node min = node;

		if (node == null) {
			System.out.println("Node empty");
			return 0;
		}

		while (min.left != null) {

			findMin(min);

		}
		return min.item;

	}

	// in order search
	public void TreeTraverse(Node node) {

		if (node != null) {
			TreeTraverse(node.left);
			System.out.println("" + node.item);

			TreeTraverse(node.right);
		}
	}

}

class Node {
	int item;
	Node parent;
	Node left;
	Node right;

	Node(int item) {
		parent = null;
		left = null;
		right = null;
		this.item = item;
	}
}