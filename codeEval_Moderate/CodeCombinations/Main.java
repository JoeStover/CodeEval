package CodeCombinations;

import java.io.*;
import java.util.*;

/**
 * Code Combinations / Challenge 238 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/238/
 * 
 * @author Joe Stover
 * @version Aug 14, 2016
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
 				System.out.println(getCountWordMatrix(buildMatrix(line)));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Builds a char matrix out of the passed in line input.
	 * 
	 * @param line String to be converted into a matrix
	 * @return char[][] matrix based on passed in string
	 */ 
	public static char[][] buildMatrix(String line)
	{
		String[] parts = line.split("\\ \\|\\ ");
		int rowSize = parts.length;
		int colSize = parts[0].length();
		char[][] matrix = new char[rowSize][colSize];
		for(int row = 0; row < rowSize; row++)
		{
			matrix[row] = parts[row].toCharArray();
		}		
		return matrix;
	}
	/**
	 * 
	 * 
	 * @param matrix
	 * @return
	 */
	public static int getCountWordMatrix(char[][] matrix)
	{
		int codeCount = 0;
		for(int row = 1; row < matrix.length; row++)
		{
			for(int col = 1; col < matrix[row].length; col++)
			{
				HashSet<Character> set = new HashSet<Character>();
				// upper left
				if(hasCode(matrix[row - 1][col - 1]))
				{
  					set.add(matrix[row - 1][col - 1]);
				}
				// upper right
				if(hasCode(matrix[row - 1][col]))
				{
					set.add(matrix[row - 1][col]);
				}
				// lower left
				if(hasCode(matrix[row][col - 1]))
				{
					set.add(matrix[row][col - 1]);
				}
				// lower right
				if(hasCode(matrix[row][col]))
				{
					set.add(matrix[row][col]);
				}
				if(set.size() == 4)
				{
					codeCount++;
				}
			}
		}
		return codeCount;
	}
	public static boolean hasCode(char letter)
	{
 		letter = Character.toLowerCase(letter);
 		return letter == 'c' || letter == 'o' || letter == 'd' || letter == 'e';
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

