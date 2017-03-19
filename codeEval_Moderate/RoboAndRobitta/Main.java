package RoboAndRobitta;

import java.io.*;

/**
 * Robo and Robitta / Challenge 212 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/212/
 * 
 * Need to refactor as the instructions were confusing
 * as no real direction was given as to how x/y coords
 * match a 0-index 2d array, or whether those coords
 * should be read the same way when constructing
 * the boundaries of the 2d board(array).
 * 
 * @author Joe Stover
 * @version March 18, 2017
 */
public class Main 
{
	public static void main(String[] args)throws IOException
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
	 * Solves challenge based on parameters specified above.
	 * 
	 * @param line single line of input from main.
	 */
	public static void solveChallenge(String line)
	{
		// parse input line and break into data points
		// for board size and stop coordinates for robo
		String[] temp = line.split("\\ \\|\\ ");
		String[] boardData = temp[0].split("x");
		String[] coordData = temp[1].split(" ");
		int colLength = Integer.parseInt(boardData[0]); // match x
		int rowLength = Integer.parseInt(boardData[1]); // match y
		/*
		 * Note: have to re-orient x and y coord because
		 * they are given as though they are on a "graph plane"
		 * with x/y axis from 0 origin (instead of 2d array index)
		 */
		int x = Integer.parseInt(coordData[0]);
		int y = Integer.parseInt(coordData[1]);
		// corresponds to "x" (right from first col, but account for 0 index)
		int colStop = x - 1; 
		// corresponds to "y" (up from last row)
		int rowStop = rowLength - y; 
		
		// board defaults to false (represents nut not yet taken by robo)
		boolean[][] board = new boolean[rowLength][colLength];
		System.out.println(getNuts(board, rowStop, colStop));
	}
	
	/**
	 * Retrieves total nuts gathered as Robo traverses the 2d array, turning
	 * 90 degrees every time he hits a boundary or empty cell. He stops
	 * when he reaches Robitta's coords (rowStop, colStop).
	 * 
	 * @param board   2d array that tracks taken nuts. True = nut was taken.
	 * @param rowStop row coordinate to cease traversal
	 * @param colStop col coordinate to cease traversal
	 * @return        total nuts gathered
	 */
	public static int getNuts(boolean[][] board, int rowStop, int colStop)
	{
		int totalNuts = 0;
		int currRow = 0;
		int currCol = 0;
		boolean done = false;
		while(!done)
		{
			// move right
			while(currCol < board[currRow].length && !board[currRow][currCol] && !done)
			{
				totalNuts++;
				board[currRow][currCol] = true;
				if(currRow == rowStop && currCol == colStop)
				{
					done = true;
				}
				currCol++;
			}
			currCol--;
			currRow++;
			// move down
			while(currRow < board.length && !board[currRow][currCol] && !done)
			{
				totalNuts++;
				board[currRow][currCol] = true;
				if(currRow == rowStop && currCol == colStop)
				{
					done = true;
				}
				currRow++;
			}
			currRow--;
			currCol--;
			// move left
			while(currCol >= 0 && !board[currRow][currCol] && !done)
			{
				totalNuts++;
				board[currRow][currCol] = true;
				if(currRow == rowStop && currCol == colStop)
				{
					done = true;
				}
				currCol--;
			}
			currCol++;
			currRow--;
			// move up
			while(currRow >= 0 && !board[currRow][currCol] && !done)
			{
				totalNuts++;
				board[currRow][currCol] = true;
				if(currRow == rowStop && currCol == colStop)
				{
					done = true;
				}
				currRow--;
			}
			currRow++;
			currCol++;
		}
		return totalNuts;
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
