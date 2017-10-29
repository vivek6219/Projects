import java.util.Scanner;
public class quadCalc 
{
	public static void main(String args[])
	{
		quadCalc obj = new quadCalc();
		double a,b,c =0;
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter a: ");
			a = sc.nextDouble();
			
			System.out.println("Enter b: ");
			b= sc.nextDouble();
			
			System.out.println("Enter c: ");
			c= sc.nextDouble();

			obj.calculate(a, b, c);
	}
	
	private void calculate(double a, double b, double c)
	{
		double x = (-b + Math.sqrt((Math.pow(b, 2) -4*a*c)))/(2*a);
		double y = (-b - Math.sqrt((Math.pow(b, 2) -4*a*c)))/(2*a);

		if(Double.isNaN(x))
			System.out.println("Imaginary");
		else
		System.out.println("The value for the addition is :" + x);

		if(Double.isNaN(y))
			System.out.println("Imaginary");
		else
		System.out.println("The value for the subtraction sis :" + y);
		
	}
}
