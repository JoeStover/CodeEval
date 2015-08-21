package StringSubstitution;

import java.io.*;

/**
 * String Substitution / Challenge 50 / Hard
 * 
 * https://www.codeeval.com/open_challenges/50/
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
				String[] parts = line.split(";");
				String answer = parts[0];
				String[] replacement = parts[1].split(",");
				for(int i = 1; i < replacement.length; i += 2)
				{
					String pattern = replacement[i - 1];
					String replaceWith = convertAB(replacement[i]);
					answer = answer.replaceAll(pattern, replaceWith);
				}
				System.out.println(convertAnswer(answer));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Converts a binary string (01) to (ab) so we know what changed 
	 * and do not replace changed chars.
	 * 
	 * @param input String to be converted
	 * @return converted String
	 */
	public static String convertAB(String input)
	{
		String result = input.replace('0', 'a');
		return result.replace('1', 'b');
		
	}
	/**
	 * Converts a's and b's within a string to binary equivalent (0's and 1's)
	 * for the answer.
	 * 
	 * @param input String to be converted to the answer
	 * @return binary answer after string is converted back
	 */
	public static String convertAnswer(String input)
	{
		String result = input.replace('a', '0');
		return result.replace('b', '1');
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

