package GameOfLife;

import java.io.*;

/**
 * Game of Life / Challenge 161 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/161/
 * 
 * @author Joe Stover
 * @version Jan 24, 2015
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
			line = reader.readLine();
			int sideLength = line.length();
			String[][] oldGameBoard = new String[sideLength][sideLength];
			oldGameBoard[0] = Main.arrayLoadLine(line);
			for(int i = 1; i < sideLength; i++)
			{
				oldGameBoard[i] = Main.arrayLoadLine(reader.readLine());
			}
			// iterate 10 times through the game
			for(int i = 1; i <= 10; i++)
			{
				oldGameBoard = Main.updateBoard(oldGameBoard);
			}
			for(int i = 0; i < oldGameBoard.length; i++)
			{
				for(int j = 0; j < oldGameBoard[0].length; j++)
				{
					System.out.print(oldGameBoard[i][j]);
				}
				System.out.println();
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Loads one row of the "Game of Life" matrix/board by converting an
	 * input string into a 1d array.
	 * 
	 * @param input string representing one row of game board
	 * @return 1d array representing the input string
	 */
	public static String[] arrayLoadLine(String input)
	{
		String[] array = new String[input.length()];
		for(int i = 0; i < input.length(); i++)
		{
			array[i] = input.substring(i, i + 1);
		}
		return array;
	}
	/**
	 * Updates a "Game of Life" game board by one move.
	 * 
	 * @param oldGameBoard game of life board (matrix) to manipulate
	 * @return game of life board (matrix) after a single iteration
	 */
	public static String[][] updateBoard(String[][] oldGameBoard)
	{
		String[][] updatedGameBoard = 
				new String[oldGameBoard.length][oldGameBoard.length];;
		// iterate through the old board
		for(int row = 0; row < oldGameBoard.length; row++)
		{
			for(int col = 0; col < oldGameBoard[0].length; col++)
			{	
				// keep the count of live neighbors
				int liveCount = 0;
				// we are in the top left corner
				if(row == 0 && col == 0)
				{
					// right
					if(oldGameBoard[row][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down right
					if(oldGameBoard[row + 1][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down
					if(oldGameBoard[row + 1][col].equals("*"))
					{
						liveCount++;
					}
				}
				// we are along the top row
				else if(row == 0 && col > 0 && 
							col < oldGameBoard.length - 1)
				{
					// right
					if(oldGameBoard[row][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down right
					if(oldGameBoard[row + 1][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down
					if(oldGameBoard[row + 1][col].equals("*"))
					{
						liveCount++;
					}
					// down left
					if(oldGameBoard[row + 1][col - 1].equals("*"))
					{
						liveCount++;
					}
					// left
					if(oldGameBoard[row][col - 1].equals("*"))
					{
						liveCount++;
					}					
				}
				// we are in the top right corner
				else if(row == 0 && col == oldGameBoard.length - 1)
				{
					// down
					if(oldGameBoard[row + 1][col].equals("*"))
					{
						liveCount++;
					}
					// down left
					if(oldGameBoard[row + 1][col - 1].equals("*"))
					{
						liveCount++;
					}
					// left
					if(oldGameBoard[row][col - 1].equals("*"))
					{
						liveCount++;
					}
				}
				// we are up against the left side
				else if(col == 0 && row > 0 && 
							row < oldGameBoard.length - 1)
				{
					// up
					if(oldGameBoard[row - 1][col].equals("*"))
					{
						liveCount++;
					}
					// up right
					if(oldGameBoard[row - 1][col + 1].equals("*"))
					{
						liveCount++;
					}					
					// right
					if(oldGameBoard[row][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down right
					if(oldGameBoard[row + 1][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down
					if(oldGameBoard[row + 1][col].equals("*"))
					{
						liveCount++;
					}
				}
				// we are up against the right side
				else if(col == oldGameBoard.length - 1 && row > 0 && 
							row < oldGameBoard.length - 1)
				{
					// up
					if(oldGameBoard[row - 1][col].equals("*"))
					{
						liveCount++;
					}
					// down
					if(oldGameBoard[row + 1][col].equals("*"))
					{
						liveCount++;
					}
					// down left
					if(oldGameBoard[row + 1][col - 1].equals("*"))
					{
						liveCount++;
					}
					// left
					if(oldGameBoard[row][col - 1].equals("*"))
					{
						liveCount++;
					}
					// up left
					if(oldGameBoard[row - 1][col - 1].equals("*"))
					{
						liveCount++;
					}
				}
				// we are at bottom left corner
				else if(row == oldGameBoard.length - 1 && col == 0)
				{
					// up
					if(oldGameBoard[row - 1][col].equals("*"))
					{
						liveCount++;
					}
					// up right
					if(oldGameBoard[row - 1][col + 1].equals("*"))
					{
						liveCount++;
					}					
					// right
					if(oldGameBoard[row][col + 1].equals("*"))
					{
						liveCount++;
					}
				}
				// we are along bottom row
				else if(row == oldGameBoard.length - 1 && col > 0 &&
							col < oldGameBoard.length - 1)
				{
					// up
					if(oldGameBoard[row - 1][col].equals("*"))
					{
						liveCount++;
					}
					// up right
					if(oldGameBoard[row - 1][col + 1].equals("*"))
					{
						liveCount++;
					}					
					// right
					if(oldGameBoard[row][col + 1].equals("*"))
					{
						liveCount++;
					}
					// left
					if(oldGameBoard[row][col - 1].equals("*"))
					{
						liveCount++;
					}
					// up left
					if(oldGameBoard[row - 1][col - 1].equals("*"))
					{
						liveCount++;
					}
				}
				// we are at the bottom right corner
				else if(row == oldGameBoard.length - 1 && 
							col == oldGameBoard.length - 1)
				{
					// up
					if(oldGameBoard[row - 1][col].equals("*"))
					{
						liveCount++;
					}
					// left
					if(oldGameBoard[row][col - 1].equals("*"))
					{
						liveCount++;
					}
					// up left
					if(oldGameBoard[row - 1][col - 1].equals("*"))
					{
						liveCount++;
					}
				}
				// we are not at an edge
				else
				{
					// up
					if(oldGameBoard[row - 1][col].equals("*"))
					{
						liveCount++;
					}
					// up right
					if(oldGameBoard[row - 1][col + 1].equals("*"))
					{
						liveCount++;
					}					
					// right
					if(oldGameBoard[row][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down right
					if(oldGameBoard[row + 1][col + 1].equals("*"))
					{
						liveCount++;
					}
					// down
					if(oldGameBoard[row + 1][col].equals("*"))
					{
						liveCount++;
					}
					// down left
					if(oldGameBoard[row + 1][col - 1].equals("*"))
					{
						liveCount++;
					}
					// left
					if(oldGameBoard[row][col - 1].equals("*"))
					{
						liveCount++;
					}
					// up left
					if(oldGameBoard[row - 1][col - 1].equals("*"))
					{
						liveCount++;
					}
				}
				// check if this index is DEAD "."
				if(oldGameBoard[row][col].equals("."))
				{   // 4) Any dead cell with exactly three live neighbors 
	  				//    becomes a live cell, as if by reproduction.
					if(liveCount == 3)
					{
						updatedGameBoard[row][col] = "*";
					}
					else
					{
						updatedGameBoard[row][col] = ".";
					}
				}
				else
				{	// 1) Any live cell with fewer than two live neighbors dies, 
					// as if caused by under-population.
					if(liveCount < 2)
					{
						updatedGameBoard[row][col] = ".";
					}
					// 3) Any live cell with more than three live neighbors dies,  
					// as if by overcrowding.
					else if(liveCount > 3)
					{
						updatedGameBoard[row][col] = ".";
					}
					// 2) Any live cell with two or three live neighbors lives 
					// on to the next generation.
					else
					{
						updatedGameBoard[row][col] = "*";
					}
				}
			}
		}
		return updatedGameBoard;
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
