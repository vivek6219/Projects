
public class Stack {

	private String arr[];
	private int top;
	private int size;

	public Stack(int size) {
		arr = new String[size];
		this.size = size;
		top = -1;
	}

	public void push(String input) {
		top++;
		arr[top] = input;
	}

	public void pop() {
		if (top == -1)
			System.out.println("EMPTY");
		System.out.print(arr[top]);

		top--;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

}
