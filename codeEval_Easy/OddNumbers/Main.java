package OddNumbers;

/**
 * Odd Numbers / Challenge 25 / Easy
 * 
 * https://www.codeeval.com/open_challenges/25/
 * 
 * "Print the odd numbers from 1 to 99."
 * 
 * @author Joe Stover
 * @version Nov 08, 2014
 */
public class Main 
{
	public static void main(String[] args) 
	{
		for (int i = 1; i < 100; i += 2)
		{
			System.out.println(i);
		}
	}
}
