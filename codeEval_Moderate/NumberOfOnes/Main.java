package NumberOfOnes;

import java.io.*;

/**
 * Number of Ones / Challenge 16 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/16/
 * 
 * @author Joe Stover
 * @version Nov 24, 2014
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
				String binary = (Integer.toBinaryString(Integer.parseInt(line)));
				int count = 0;
				for(int i = 0; i < binary.length(); i++)
				{
					if(binary.charAt(i) == '1')
					{
						count++;
					}
				}
				System.out.println(count);
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
