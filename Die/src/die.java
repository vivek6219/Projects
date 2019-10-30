import java.util.Arrays;

public class die 
{
	int[][] dice;

	public static void main(String args[])
	{
		die obj = new die();
		obj.calcTarget(1,6,3);
	}
	
	public int algo(int num, int side, int target)
	{
		int sum=0;
		if(dice[num][target]!=1)
			return dice[num][target];
		if(num ==1){
		{
			if(target ==0)
				return 0;
		}
		
		if(side>=target)
			return 1;
		return 0;
		
		}
		
		for(int i=0; i<side; i++)
		{
			int first = algo(1 ,6 ,1);
			int second = (target-i>=0) ? algo(num-1,6, target-i):0;
			
			sum+= (first*second);
		}
		dice[num][target] = sum;
		return sum;
	}
	
	
	public  int calcTarget(int num , int side, int target)
	{
		dice = new int[num+1][Math.max(target, side)+1];
		for(int i = 0; i< dice.length; i++)
		{
			for(int j=0; j<dice.length; j++)
			{
				dice[i][j] = -1;
			}
		}
		
		return algo(num, side, target);
	}
	

}
