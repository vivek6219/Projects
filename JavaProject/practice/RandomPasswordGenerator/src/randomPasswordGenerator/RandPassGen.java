package randomPasswordGenerator;
import java.util.Random;
import java.util.Scanner;

public class RandPassGen 
{
	public static void main(String args[])
	{

		RandPassGen obj = new RandPassGen();
		int passLength;
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want a password with both characters and numbers or numbers only?");
		System.out.println("Press c for characters and numbers or n for numbers only");
		String choice = sc.nextLine();
		choice=choice.toLowerCase();

		System.out.println("Enter the length of the password: ");
		passLength = sc.nextInt();
		if(choice.equals("c"))
		{
			char[] charGeneratedPassword = obj.stringGen(passLength);
			obj.charPrint(charGeneratedPassword);
		}
		else if(choice.equals("n"))
		{
			//System.out.println("passLength is " + passLength);
			int[] generatedPassword = obj.passwordGen(passLength);

			obj.print(generatedPassword);
		}
		else
		{
			System.out.println("Press c or n");
			while(sc.hasNext())
			{
				if(choice.equals("c") || choice.equals("s"))
					break;
			}
		}
		sc.close();

	}

	private int[] passwordGen(int passwordSize)
	{
		Random password = new Random();
		int []passwordArr = new int[passwordSize];
		//String[] strPasswordArr = new String[passwordSize];
		for(int i =0; i< passwordArr.length; i++)
		{
			int x = password.nextInt(9);
			passwordArr[i] = x;
		}


		return passwordArr;
	}

	private void print(int[] passedArray)
	{
		for(int i =0; i < passedArray.length; i++)
		{
			System.out.print(passedArray[i]);
		}
	}

	private char[] stringGen(int passWordSize)
	{
		char arr[] = new char[passWordSize];
		String charofStrings = "abcdefghijklmonpqrstuvwxyz1234567890ABCDEFGHIJKLMNOQRSTUVWXYZ!@#$%^&*()_+{}[]<>/?";
		Random rand = new Random();
		for(int i =0; i<arr.length; i++)

			arr[i] = charofStrings.charAt(rand.nextInt(charofStrings.length()));

		return arr;
	}

	private void charPrint(char[] passedArray)
	{
		for(int i =0; i < passedArray.length; i++)
		{
			System.out.print(passedArray[i]);
		}
	}

}


