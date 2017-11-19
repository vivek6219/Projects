package insertionSort;

public class InsertionSort 
{
	public static void main(String args[])
	{
		int arr[] = {0,-4,-1,3,2}; 
		int temp ;
		for(int i =0; i<arr.length; i++)
		{
			for(int j =i+1; j<arr.length; j++)
			{
				if(arr[i]>arr[j])
				{
					temp   = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				
			}
			
			for(int k=0;k<arr.length;k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println("");
		}
		
		for(int i =0; i<arr.length; i++)
		{
			System.out.print(arr[i]);
		}
	}
}
