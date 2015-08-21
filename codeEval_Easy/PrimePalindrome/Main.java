package PrimePalindrome;

/**
 * Prime Palindrome / Challenge 3 / Easy
 * 
 * https://www.codeeval.com/open_challenges/3/
 * 
 * "Write a program which determines the largest prime palindrome 
 *  less than 1000."
 * 
 * @author Joe Stover
 * @version Nov 13, 2014
 */
public class Main 
{
	public static void main(String[] args)
	{
		int number = 999;
		boolean hasNoAnswer = true;
		while(hasNoAnswer)
		{
			if(Main.isPalindrome(number) && Main.isPrime(number))
			{
				hasNoAnswer = false;
				System.out.print(number);
			}
			else
			{
				number--;
			}
		}
	}
	/**
	 * Checks if a number is a palindrome.
	 * 
	 * @param num to be checked
	 * @return true if num is a palindrome, false otherwise
	 */
	public static boolean isPalindrome(int num)
	{
		String number = num + "";
		// base case
		if (number.length() < 2)
		{
			return true;
		}
		if (number.charAt(0) != number.charAt(number.length() - 1))
		{
			return false;
		}
		return isPalindrome(Integer.parseInt(
				number.substring(1, number.length() -1)));
	}
	/**
	 * Check if a number is prime.
	 * 
	 * @param num to be checked
	 * @return true if the num is prime, false otherwise
	 */
	public static boolean isPrime(int num)
	{
		for(int i = 2; i <= num/2; i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
