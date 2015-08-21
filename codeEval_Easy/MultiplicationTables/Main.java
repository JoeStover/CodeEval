package MultiplicationTables;

/**
 * Multiplication Tables / Challenge 23 / Easy
 * 
 * https://www.codeeval.com/open_challenges/23/
 * 
 * "Print out the grade school multiplication table up to 12*12."
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
 */
public class Main 
{
	public static void main(String[] args)
	{
		for(int i = 1; i < 13; i++)
		{
			for(int j = 1; j < 13; j++)
			{
				System.out.printf("%4d", (i) * (j));
			}
			System.out.println("");
		}
	}
}
