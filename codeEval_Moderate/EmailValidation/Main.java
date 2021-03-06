package EmailValidation;

import java.io.*;

/**
 * Email Validation / Challenge 35 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/35/
 * 
 * @author Joe Stover
 * @version Dec 03, 2014
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
				if(line.matches("^[\\w-\\.\\+]+(\\.[\\w-]+)*@[A-Za-z0-9-]+(\\.[\\w]+)*(\\.[A-Za-z]{2,})$|" +
		                "^\"[\\w-\\.\\+@]+(\\.[\\w-]+)*\"@[\\w-]+(\\.[\\w]+)*(\\.[A-Za-z]{2,})$"))
				{
					System.out.println("true");
				}
				else
				{
					System.out.println("false");
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
