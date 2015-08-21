package MatrixRotation;

import java.io.*;

/**
 * Matrix Rotation / Challenge 178 / Easy
 * 
 * https://www.codeeval.com/open_challenges/178/
 * 
 * @author Joe Stover
 * @version Jan 15, 2015
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
				System.out.println(
						Main.convertMatrixToLine(
								Main.rotateRight(
										Main.convertLineToMatrix(line))));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Takes line input and converts it into a character matrix.
	 * 
	 * @param line to be converted
	 * @return a character matrix
	 */
	public static char[][] convertLineToMatrix(String line)
	{
		char[] list = line.replace(" ", "").toCharArray();
		int edgeSize = (int) Math.sqrt(list.length);
		char[][] matrix = new char[edgeSize][edgeSize];
		int counter = 0;
		for(int row = 0; row < edgeSize; row++)
		{
			for(int col = 0; col < edgeSize; col++)
			{
				matrix[row][col] = list[counter];
				counter++;
			}
		}	
		return matrix;
	}
	/**
	 * Takes a character matrix and rotates it to the right.
	 * 
	 * @param matrix to be rotated
	 * @return the rotated matrix
	 */
	public static char[][] rotateRight(char[][] matrix)
	{
		char[][] result = new char[matrix.length][matrix[0].length];
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				result[row][col] = matrix[matrix[0].length - 1 - col][row];
			}
		}	
		return result;
	}
	/**
	 * Converts a matrix back into a line.
	 * 
	 * @param matrix to be converted
	 * @return a string representing the matrix
	 */
	public static String convertMatrixToLine(char[][] matrix)
	{
		String result = "";
		for(int row = 0; row < matrix.length; row++)
		{
			for(int col = 0; col < matrix[0].length; col++)
			{
				result = result + matrix[row][col] + " ";
			}
		}	
		return result.trim();
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
