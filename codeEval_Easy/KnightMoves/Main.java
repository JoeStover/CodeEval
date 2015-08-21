package KnightMoves;

import java.io.*;
import java.util.ArrayList;

/**
 * Knight Moves / Challenge 180 / Easy
 * 
 * https://www.codeeval.com/open_challenges/180/
 * 
 * @author Joe Stover
 * @version Jan 23, 2015
 */
public class Main 
{
	final static String[][] CHESSBOARD = {
		{"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
		 {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
		 {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
		 {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
		 {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
		 {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
		 {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
		 {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}};
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				// just swap positions for row
				int row = 8 - Character.getNumericValue(line.charAt(1));
				// use ascii values for quick conversion
				// (e.g. "a" = dec 97, "b" = dec 98, etc)
				int col = (int)line.charAt(0) - 97;
				ArrayList<String> moves = new ArrayList<String>();
				/* Knight has 8 move possibilities */
				// 1) LEFT 2 DOWN 1
				if(isValidMove(row + 1, col - 2))
				{
					moves.add(CHESSBOARD[row + 1][col - 2]);
				}
				// 2) LEFT 2 UP 1
				if(isValidMove(row - 1, col - 2))
				{
					moves.add(CHESSBOARD[row - 1][col - 2]);
				}
				// 3) LEFT 1 DOWN 2
				if(isValidMove(row + 2, col - 1))
				{
					moves.add(CHESSBOARD[row + 2][col - 1]);
				}
				// 4) LEFT 1 UP 2
				if(isValidMove(row - 2, col - 1))
				{
					moves.add(CHESSBOARD[row - 2][col - 1]);
				}
				// 5) RIGHT 1 DOWN 2
				if(isValidMove(row + 2, col + 1))
				{
					moves.add(CHESSBOARD[row + 2][col + 1]);
				}
				// 6) RIGHT 1 UP 2
				if(isValidMove(row - 2, col + 1))
				{
					moves.add(CHESSBOARD[row - 2][col + 1]);
				}
				// 7) RIGHT 2 DOWN 1
				if(isValidMove(row + 1, col + 2))
				{
					moves.add(CHESSBOARD[row + 1][col + 2]);
				}
				// 8) RIGHT 2 UP 1
				if(isValidMove(row - 1, col + 2))
				{
					moves.add(CHESSBOARD[row - 1][col + 2]);
				}
				for(String move : moves)
				{
					System.out.print(move + " ");
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
	 * Verifies that a move is valid.
	 * 
	 * @param rowMove location of the row
	 * @param colMove location of the column
	 * @return true if the move is valid, false otherwise
	 */
	public static boolean isValidMove(int rowMove, int colMove)
	{
		// return whether or not row and col is within 2d indices
		return (rowMove >= 0 && rowMove < 8 && colMove >= 0 && colMove < 8);	
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
