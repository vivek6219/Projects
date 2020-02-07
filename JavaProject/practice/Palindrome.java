
public class Palindrome {
	public static void main(String args[])
	{
		String orig = "bab";
		String rev = "";
		for(int i =orig.length()-1; i>=0; i--)
		{
			rev +=orig.charAt(i);
		}
		
		boolean isPalindrome = true;
		for(int j=0; j<orig.length(); j++)
		{
			if(orig.charAt(j)!=rev.charAt(j))
				isPalindrome=false;
		}
		
		System.out.println(isPalindrome);
	}


}
