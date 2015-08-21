package MinimumPathSum;

import java.io.*;

/**
 * Minimum Path Sum / Challenge 72 / Hard
 * 
 * https://www.codeeval.com/open_challenges/72/
 * 
 * @author Joe Stover
 * @version Feb 03, 2015
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
			int length = Integer.parseInt(line);
			int[][] matrix = new int[length][length];
			for(int row = 0; row < length; row++)
			{
				String[] parts = reader.readLine().split(",");
				for(int col = 0; col < length; col++)
				{
					matrix[row][col] = Integer.parseInt(parts[col]);
				}
			}
			System.out.println(getMinPathSum(matrix));
		}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Finds the minimum path sum from the top left most indices of a matrix
	 * to the bottom right. (Uses a DP solution instead of DFS).
	 * 
	 * @param numbers the matrix to be evaluated
	 * @return the path of integers that yields the smallest sum from top left
	 *         to bottom right of the input matrix
	 */
	public static int getMinPathSum(int[][] numbers)
	{
		// we are taking a bottom up approach so start at bottom of matrix
		for(int row = numbers.length - 1; row >= 0; row--)
		{
			// again, bottom up so start at far right
			for(int col = numbers.length - 1; col >= 0; col--)
			{
				// initialize to max int since we are looking for min
				int valOne = Integer.MAX_VALUE;
				int valTwo = Integer.MAX_VALUE;
				// can't start at corner or we will throw array index OOB error
				if(row != numbers.length - 1 || col != numbers.length - 1)
				{
					if(row < numbers.length - 1)
					{
						// value of a horizontal move
						valOne = numbers[row + 1][col];
					}					
					if(col < numbers.length - 1)
					{
						// value of a vertical move
						valTwo = numbers[row][col + 1] ;
					}
					// figure out which move was "cheaper" and store it
					if(valOne < valTwo)
					{
						numbers[row][col] += valOne;
					}
					else
					{
						numbers[row][col] += valTwo;
					}
				}
			}
		}
		// return sum stored in our origin (since we went bottom up)
		return numbers[0][0];
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
