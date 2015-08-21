package QueryBoard;

import java.io.*;

/**
 * Query Board / Challenge 87 / Easy
 * 
 * https://www.codeeval.com/open_challenges/87/
 * 
 * Note: Should break the individual calls into their own methods for encapsulation
 *       and reuse purposes.
 * 
 * @author Joe Stover
 * @version Nov 14, 2014
 */
public class Main 
{
	final static int[][] BOARD =
			new int[256][256];
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(" ");
				int sum = 0;
				if(parts[0].equals("SetCol"))
				{
					for(int i = 0; i < BOARD.length; i++)
					{
						BOARD[i][Integer.parseInt(parts[1])] = 
								Integer.parseInt(parts[2]);
					}
				}
				else if(parts[0].equals("SetRow"))
				{
					for(int i = 0; i < BOARD.length; i++)
					{
						BOARD[Integer.parseInt(parts[1])][i] = 
								Integer.parseInt(parts[2]);
					}
				}
				else if(parts[0].equals("QueryCol"))
				{
					for(int i = 0; i < BOARD.length; i++)
					{
						sum = sum + BOARD[i][Integer.parseInt(parts[1])];
					}
					System.out.println(sum);
				}
				else if(parts[0].equals("QueryRow"))
				{
					for(int i = 0; i < BOARD.length; i++)
					{
						sum = sum + BOARD[Integer.parseInt(parts[1])][i];
					}
					System.out.println(sum);
				}
			}			
		}
		finally
		{
			reader.close();
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
