package BitPositions;

import java.io.*;

/**
 * Bit Positions / Challenge 19 / Easy
 * 
 * https://www.codeeval.com/open_challenges/19/
 * 
 * " Given a number n and two integers p1,p2 determine if the bits in 
 *   position p1 and p2 are the same or not. Positions p1 and p2 are 1 based."
 * 
 * @author Joe Stover
 * @version Nov 14, 2014
 *
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
				String[] parts = line.split(",");
				String bits = Integer.toBinaryString(Integer.parseInt(parts[0]));
				char p1 = bits.charAt(bits.length() - Integer.parseInt(parts[1]));
				char p2 = bits.charAt(bits.length() - Integer.parseInt(parts[2]));
				System.out.println(p1 == p2);
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
