package Sudoku;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Sudoku / Challenge 78 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/78/
 * 
 * @author Joe Stover
 * @version June 7, 2016
 * 
 * TODO: At 100% on CodeEval, but using a hard-coded check for valid sub-grids.
 *       want to refactor so it will work regardless of grid size and not 
 *       hard-coded checks on 3x3 and 9x9.
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
				if(validSubGridsHardcoded(board) && 
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
	 * 
	 * Dynamically checks that sub-grids contain a valid sudoku solution
	 * based on grid size.
	 * 
	 * @param size of the grids
	 * @param digits grid to be checked
	 * @return true if valid, false otherwise
	 * 
	 * @ToDo: Redo this method ...
	 */
	public static boolean validSubGrids(String[][] board)
	{
		boolean isValid = true;
		// logic goes here :)
		return isValid;
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
	
	/**
	 * Cheap way to solve the valid subgrids issue. Since we know it is
	 * 4x4 or 9x9, can hard-code the checks. Dynamic would be better solution
	 * but still working on that.
	 * 
	 * @param board to be checked for valid sudoku subgrids
	 * @return true if subgrid is valid, false otherwise
	 */
	public static boolean validSubGridsHardcoded(String[][] board)
	{
		boolean isValid = true;
		HashSet<String> solution = new HashSet<String>();
		if(board.length == 4)
		{
			//upper left
			if(isValid)
			{
				solution.add(board[0][0]);
				solution.add(board[0][1]);
				solution.add(board[1][0]);
				solution.add(board[1][1]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//upper right
			if(isValid)
			{
				solution.add(board[0][2]);
				solution.add(board[0][3]);
				solution.add(board[1][2]);
				solution.add(board[1][3]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//lower left
			if(isValid)
			{
				solution.add(board[2][0]);
				solution.add(board[2][1]);
				solution.add(board[3][0]);
				solution.add(board[3][1]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//lower right
			if(isValid)
			{
				solution.add(board[2][2]);
				solution.add(board[2][3]);
				solution.add(board[3][2]);
				solution.add(board[3][3]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			
		}
		else if(board.length == 9)
		{
			//upper left
			if(isValid)
			{
				solution.add(board[0][0]);
				solution.add(board[0][1]);
				solution.add(board[0][2]);
				solution.add(board[1][0]);
				solution.add(board[1][1]);
				solution.add(board[1][2]);
				solution.add(board[2][0]);
				solution.add(board[2][1]);
				solution.add(board[2][2]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//upper middle
			if(isValid)
			{
				solution.add(board[0][3]);
				solution.add(board[0][4]);
				solution.add(board[0][5]);
				solution.add(board[1][3]);
				solution.add(board[1][4]);
				solution.add(board[1][5]);
				solution.add(board[2][3]);
				solution.add(board[2][4]);
				solution.add(board[2][5]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//upper right
			if(isValid)
			{
				solution.add(board[0][6]);
				solution.add(board[0][7]);
				solution.add(board[0][8]);
				solution.add(board[1][6]);
				solution.add(board[1][7]);
				solution.add(board[1][8]);
				solution.add(board[2][6]);
				solution.add(board[2][7]);
				solution.add(board[2][8]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//left
			if(isValid)
			{
				solution.add(board[3][0]);
				solution.add(board[3][1]);
				solution.add(board[3][2]);
				solution.add(board[4][0]);
				solution.add(board[4][1]);
				solution.add(board[4][2]);
				solution.add(board[5][0]);
				solution.add(board[5][1]);
				solution.add(board[5][2]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//middle
			if(isValid)
			{
				solution.add(board[3][3]);
				solution.add(board[3][4]);
				solution.add(board[3][5]);
				solution.add(board[4][3]);
				solution.add(board[4][4]);
				solution.add(board[4][5]);
				solution.add(board[5][3]);
				solution.add(board[5][4]);
				solution.add(board[5][5]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//right
			if(isValid)
			{
				solution.add(board[3][6]);
				solution.add(board[3][7]);
				solution.add(board[3][8]);
				solution.add(board[4][6]);
				solution.add(board[4][7]);
				solution.add(board[4][8]);
				solution.add(board[5][6]);
				solution.add(board[5][7]);
				solution.add(board[5][8]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//bottom left
			if(isValid)
			{
				solution.add(board[6][0]);
				solution.add(board[6][1]);
				solution.add(board[6][2]);
				solution.add(board[7][0]);
				solution.add(board[7][1]);
				solution.add(board[7][2]);
				solution.add(board[8][0]);
				solution.add(board[8][1]);
				solution.add(board[8][2]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//bottom middle
			if(isValid)
			{
				solution.add(board[6][3]);
				solution.add(board[6][4]);
				solution.add(board[6][5]);
				solution.add(board[7][3]);
				solution.add(board[7][4]);
				solution.add(board[7][5]);
				solution.add(board[8][3]);
				solution.add(board[8][4]);
				solution.add(board[8][5]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
			//bottom right
			if(isValid)
			{
				solution.add(board[6][6]);
				solution.add(board[6][7]);
				solution.add(board[6][8]);
				solution.add(board[7][6]);
				solution.add(board[7][7]);
				solution.add(board[7][8]);
				solution.add(board[8][6]);
				solution.add(board[8][7]);
				solution.add(board[8][8]);
				if(solution.size() != board.length)
				{
					isValid = false;
				}
				else
				{
					solution = new HashSet<String>();
				}
			}
		}
		return isValid;
	}
}
