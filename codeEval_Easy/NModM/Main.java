package NModM;

import java.io.*;

/**
 * N Mod M / Challenge 62 / Easy
 * 
 * https://www.codeeval.com/open_challenges/62/
 * 
 * "Given two integers N and M, calculate N Mod M 
 * (without using any inbuilt modulus operator)."
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
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
				int n = Integer.parseInt(parts[0]);
				int m = Integer.parseInt(parts[1]);
				int mod = n - ((n / m) * m);
				System.out.println(mod);
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
