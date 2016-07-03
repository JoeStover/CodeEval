package TwentyFortyEight;

import java.io.*;

/**
 * Twenty Forty Eight / Challenge 194 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/194/
 * 
 * @author Joe Stover
 * @version still working on it (not submitted to CodeEval yet)
 * 
 * TODO: Fix the merge right logic and use that to complete the other "shift"
 *       methods. Previous attempts failed at the merge logic. Just need to 
 *       spend some more time working out the kinks. Removed previous attempt
 *       at merge right to get a fresh start.
 *       
 *       Added the Tile inner class to keep track of whether a tile
 *       has already been "merged."
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
				String[] parts = line.split("; ");
				String shiftDir = parts[0];
				int gridSize = Integer.parseInt(parts[1]);
				String gridData = parts[2];
				Tile[][] gameBoard = 
						createGameBoard(gridSize, gridData);
				processMove(gameBoard, shiftDir);
				System.out.println(boardToString(gameBoard));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Creates a 2048 game board.
	 * 
	 * @param size integer representing the game board dimensions
	 * @param input string representing current tiles to be placed on the board
	 * @return 2d matrix representing the game board 
	 */
	public static Tile[][] createGameBoard(int size, 
			String input)
	{
		Tile[][] gameBoard = 
				new Tile[size][size];
		String[] rows = input.split("\\|");
		for(int row = 0; row < size; row++)
		{
			String[] temp = rows[row].split(" ");
			for(int col = 0; col < size; col++)
			{
				gameBoard[row][col] = new Tile(Integer.parseInt(temp[col]));
			}
		}	
		return gameBoard;
	}
	/**
	 * Processes one move in the 2048 game.
	 * 
	 * @param 2d array representing a 2048 board
	 * @param dir the direction of the move
	 */
	public static void processMove(Tile[][] board, 
			String dir)
	{
		if(dir.equals("RIGHT"))
		{
			shiftRight(board);
		}
		else if(dir.equals("LEFT"))
		{
			shiftLeft(board);
		}
		else if(dir.equals("UP"))
		{
			shiftUp(board);
		}
		else
		{
			shiftDown(board);
		}
	}
	/**
	 * Moves all tiles to the right, conforming to the 2048 rules specified
	 * in the challenge description.
	 * 
	 * @param board 2d array representing a 2048 board
	 */
	public static void shiftRight(Tile[][] board)
	{
		
	}
	/**
	 * Moves all tiles to the left, conforming to the 2048 rules specified
	 * in the challenge description.
	 * 
	 * @param board 2d array representing a 2048 board
	 */
	public static void shiftLeft(Tile[][] board)
	{
		
	}
	/**
	 * Moves all tiles up, conforming to the 2048 rules specified
	 * in the challenge description.
	 * 
	 * @param board 2d array representing a 2048 board
	 */
	public static void shiftUp(Tile[][] board)
	{
		
	}
	/**
	 * Moves all tiles down, conforming to the 2048 rules specified
	 * in the challenge description.
	 * 
	 * @param board 2d array representing a 2048 board
	 */
	public static void shiftDown(Tile[][] board)
	{
		
	}
	/**
	 * Converts the 2048 board into a string representation for printing.
	 * 
	 * @param board 2d array representing a 2048 board
	 * @return a String representing the 2048 board
	 */
	public static String boardToString(Tile[][] board)
	{
		String postMove = "";
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				postMove += board[row][col].value + " ";
			}
			postMove = postMove.trim() + "|";
		}
		return postMove.substring(0, postMove.length() - 1);
	}
	/**
	 * Inner class that represents a 2048 tile. A tile has a specified
	 * numeric value and keeps track of whether it has been "merged"
	 * with another tile during a game move.
	 * 
	 * "If two tiles of the same number collide while moving, they will merge 
	 *  into a tile with the total value of the two tiles that collided. The 
	 *  resulting tile CANNOT merge with another tile again in the same move"
	 */
	public static class Tile
	{
		int value;
		boolean hasMerged; // keeps track of merges, RESET to false at end of move
		
		public Tile(int data)
		{
			this.value = data;
			this.hasMerged = false;
		}		
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