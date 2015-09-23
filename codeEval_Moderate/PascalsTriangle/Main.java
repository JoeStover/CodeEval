package PascalsTriangle;

import java.io.*;

/**
 * Pascals Triangle / Challenge 66 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/66/
 * 
 * @author Joe Stover
 * @version Sept 21, 2015
 */
public class Main 
{
	
	public static void main(String[] args) throws IOException
	{		
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				System.out.println(getPascalsTriangle(Integer.parseInt(line)));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Calculates all rows of Pascal's triangle up to the specified row count and
	 * returns those rows as a String. 
	 * 
	 * See https://en.wikipedia.org/wiki/Pascal%27s_triangle for explanation
	 * of row algorithm.
	 *    
	 * @param rowCount last row 
	 * @return a String representing all rows up to the specified row, inclusive
	 */
	public static String getPascalsTriangle(int rowCount)
	{
		rowCount--;
		int prev = 1;
		String triangle = "";	
		for(int row = 0; row <= rowCount; row++)
		{
			for(int k = 0; k <= row; k++)
			{
				if(k == 0)
				{
					prev = 1;
					triangle += prev + " ";
				}
				else
				{
					prev = calculateElement(prev, row, k);
					triangle += prev + " ";
				}
			}
		}	
		return triangle.trim();
	}
	/**
	 * Calculates the current element in the Pascals triangle based on row number,
	 * element position, and previous element value:
	 * 
	 * (  n  )  = (  n  ) *  (n + 1 - k) / k
	 *    k		   k - 1
	 *    
	 * @param prev value of the prior element in row
	 * @param n    current row index
	 * @param k    index position within current row
	 * @return     calculated value of this element
	 */
	public static int calculateElement(int prev, int n, int k)
	{
		// cast to double as 2nd term can be fractional
		// round up or down as needed after calculation and cast back to int
		return (int) Math.round((prev * ((double)(n + 1 - k) / k)));
	}
	/**
	 * Generates a BufferedReader for a file, either from passed in
	 * arguments or an input.txt file based on relation to this class.
	 * 
	 * @param args array of arguments passed to Main. If no args, finds
	 *             input.txt based on class location
	 * @return a BufferedReader based on input file
	 * @throws IOException if file is not found
	 */
	public static BufferedReader generateInputReader(String[] args) 
			throws IOException
	{
		if(args.length == 0)
		{
			InputStream stream = Main.class.getResourceAsStream("input.txt");
			return new BufferedReader(new InputStreamReader(stream));
		}
		else
		{
			return new BufferedReader(new FileReader(args[0]));
		}
	}
}
