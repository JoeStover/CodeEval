package SpiralPrinting;

import java.io.*;
import java.util.Arrays;

/**
 * Spiral Printing / Challenge 57 / Hard
 * 
 * https://www.codeeval.com/open_challenges/57/
 * 
 * Note: Could probably refactor to remove the 2nd matrix (to save on 
 * space complexity). Originally just kept track of row and col bounds
 * but solution missed some edge cases.
 * 
 * @author Joe Stover
 * @version June 21, 2016
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
				solveChallenge(line);
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Solves the given challenge based on challenge rules/description.
	 * 
	 * @param line String input to be solved
	 */
	public static void solveChallenge(String line)
	{
		String[] parts = line.split(";");
		int rowSize = Integer.parseInt(parts[0]);
		int colSize = Integer.parseInt(parts[1]);
		String[] array = parts[2].split(" ");
		String[][] matrix = buildMatrix(array, rowSize, colSize);
		printMatrix(matrix); // TODO: remove once debugged
		System.out.println(); // TODO: remove once debugged
		sprialPrintMatrix(matrix);		
	}
	/**
	 * Builds a matrix based on a passed in array and
	 * settings for row and column length. Array is 
	 * in "row major" order.
	 * 
	 * @param array  to be converted into a matrix
	 * @param rowSize length of all rows
	 * @param colSize length of all columns
	 * @return a 2d array (matrix)
	 */
	public static String[][] buildMatrix(String[] array, int rowSize, int colSize)
	{
		String[][] matrix = new String[rowSize][colSize];
		int i = 0;
		for(int row = 0; row < rowSize; row++)
		{
			for(int col = 0; col < colSize; col++)
			{
				matrix[row][col] = array[i];
				i++;
			}
		}		
		return matrix;
	}
	/**
	 * Prints a matrix to system.out in "spiral order". Spiral
	 * order is a counter-clockwise spiral through a matrix
	 * from [0][0] to the center until all cells are exhausted.
	 * 
	 * @param matrix to be printed
	 */
	public static void sprialPrintMatrix(String[][] matrix)
	{
		// keep track of visited cells in a matrix (defaults to false)
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		// track print cursor
		int row = 0;
		int col = 0;
		// track if cursor has moved
		boolean hasMoved = true;
		// keep spiraling until we run out of moves
		while(hasMoved)
		{
			hasMoved = false;
			// move right
			while(col < matrix[row].length && !visited[row][col])
			{
				System.out.print(matrix[row][col] + " ");
				visited[row][col] = true;
				col++;
				hasMoved = true;
			}
			col--; // move row back in bounds
			row++; // corner printed, so move down
			// move down
			while(row < matrix.length && !visited[row][col])
			{
				System.out.print(matrix[row][col] + " ");
				visited[row][col] = true;
				row++;
				hasMoved = true;
			}
			row--; // move col back in bounds
			col--; // corner printed so move left
			// move left
			while(col >= 0 && !visited[row][col])
			{
				System.out.print(matrix[row][col] + " ");
				visited[row][col] = true;
				col--;
				hasMoved = true;
			}
			col++; // move col back in bounds
			row--; // corner printed, so move up
			// move up
			while(row >= 0 && !visited[row][col])
			{
				System.out.print(matrix[row][col] + " ");
				visited[row][col] = true;
				row--;
				hasMoved = true;
			}
			row++; // move row back in bounds			
		}	
		System.out.println(); // new line
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
	/**
	 * Prints a matrix to system.out.
	 * 
	 * Used for visual debugging purposes only (not part of solution).
	 * 
	 * @param matrix to be printed
	 */
	public static void printMatrix(String[][] matrix)
	{
		for(String[] row : matrix)
		{
			System.out.println(Arrays.toString(row));
		}
	}
}