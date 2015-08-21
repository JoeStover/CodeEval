package Sudoku;

import java.io.*;
import java.util.HashSet;

/**
 * Sudoku / Challenge 78 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/78/
 * 
 * @author Joe Stover
 * @version Mar 30, 2015
 * 
 * TODO: Need to refactor my code, as it only gets 95% on CodeEval. I think
 * it has to do with how I am making the board, but I need to find time to actually
 * walk through with the debugger.
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
				String[] parts = line.split(";");
				int size = Integer.parseInt(parts[0]);
				String[] digits = parts[1].split(",");
				String[][] board = makeBoard(size, digits);
				if(validSubGrids(size, digits) && 
						validRows(board) && 
							validCols(board))
				{
					System.out.println("True");
				}
				else
				{
					System.out.println("False");
				}						
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Checks that sub-grids contain a valid sudoku solution.
	 * 
	 * @param size of the grids
	 * @param digits grid to be checked
	 * @return true if valid, false otherwise
	 */
	public static boolean validSubGrids(int size, String[] digits)
	{
		boolean isSolution = true;
		for(int i = 0; i < digits.length; i += size)
		{
			HashSet<String> solution = new HashSet<String>();
			for(int j = i; j < i + size; j++)
			{
				solution.add(digits[j]);
			}
			if(solution.size() != size)
			{
				isSolution = false;
			}
		}
		return isSolution;
	}
	/**
	 * Checks that a row is a valid sudoku solution.
	 * 
	 * @param board sudoku board to check
	 * @return true if valid, false otherwise
	 */
	public static boolean validRows(String[][] board)
	{
		boolean isSolution = true;
		for(int row = 0; row < board.length; row++)
		{
			HashSet<String> solution = new HashSet<String>();
			for(int col = 0; col < board.length; col++)
			{
				solution.add(board[row][col]);
			}
			if(solution.size() != board.length)
			{
				isSolution = false;
			}
		}
		return isSolution;
	}
	/**
	 * Checks that a column is a valid sudoku solution.
	 * 
	 * @param board sudoku board to check
	 * @return true if valid, false otherwise
	 */
	public static boolean validCols(String[][] board)
	{
		boolean isSolution = true;
		for(int col = 0; col < board.length; col++)
		{
			HashSet<String> solution = new HashSet<String>();
			for(int row = 0; row < board.length; row++)
			{
				solution.add(board[row][col]);
			}
			if(solution.size() != board.length)
			{
				isSolution = false;
			}
		}
		return isSolution;
	}
	/**
	 * Creates a sudoku board based on passed in string array
	 * @param size of the board edges
	 * @param digits string array to convert to sudoku board
	 * @return 2d array representing a sudoku board
	 */
	public static String[][] makeBoard(int size, String[] digits)
    {
		String[][] board = new String[size][size];
		int i = 0;
		for(String num : digits)
		{
			board[i / size][i % size] = num;
			i++;
		}
		return board;
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
