import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Casino 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter  a bet amount or enter 0 to quit: ");
		int userInput = sc.nextInt();
		int counter =0;
		String space = "space"; //50%
		String cherries = "cherries"; //25%
		String bar = "BAR"; //12.5%
		String seven ="7"; //12.5%
		
		
		if(userInput == 0)
		{
			System.out.println("You quit");
			return;
		}
		while(counter<3)
		{
			double chance =  (Math.random() *100);
			BigDecimal bd = BigDecimal.valueOf(chance);
			bd = bd.setScale(1,RoundingMode.HALF_UP);
			chance = bd.doubleValue();
			
			if(chance==50.00) //(50%)
			{
				System.out.println(space);
				counter++;
			}
				
			else if(chance==25.00) //(25%)
			{
				System.out.println(cherries);
				counter++;
			}
				
			else if(chance == 12.5) //(12.5%)
				{
					System.out.println(bar);
					counter++;
				}
			else if(chance == 12.5)
				{
					System.out.println(seven);
					counter++;
				}

		}
		
	
	}
}
