import java.util.Scanner;
public class QuadraticCalculator2
{
	public static void main(String args[])
	{
		QuadraticCalculator2 obj = new QuadraticCalculator2();
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		obj.calc(a,b,c);
	}
	
	public void calc(int a , int b, int c)
	{
		double x1 = -b + Math.sqrt((Math.pow(b, 2) - (4*a*c)));
		double x2 = -b - Math.sqrt((Math.pow(b, 2) - (4*a*c)));
		
		System.out.println("The addition is: " + x1 + " The subtraction is " + x2);
	
	}
	

}
