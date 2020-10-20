import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Exercise 1.1 from OpenDataStructures.org book

/*
Solve the following problems by reading a text file one line at a time
and performing operations on each line in the appropriate data structure(s). 
Your implementations should be fast enough that even files containing a 
million lines can be processed in a few seconds
*/
public class Main {

	static File file = new File("D:\\DataStructuresWorkspace\\Exercise1.1\\src\\InputFile");
	// going to have some file. Read in each line from the file. Then write lines in
	// reverse order (last line is read first.)

	public static void main(String args[]) throws Exception {

		Stack stackObj = new Stack(20);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				stackObj.push(data);
				System.out.print(data);
			}
			sc.close();
		}

		catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("----Reversed---");

		while (!stackObj.isEmpty()) {
			stackObj.pop();
		}

	}

}
