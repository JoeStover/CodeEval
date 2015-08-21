package SwapNumbers;

import java.io.*;

/**
 * Swap Numbers / Challenge 196 / Easy
 * 
 * https://www.codeeval.com/open_challenges/196/
 * 
 * @author Joe Stover
 * @version May 15, 2015
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
				String[] words = line.split(" ");
				System.out.println(numberSwapper(words));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Swaps the first and last number surrounding each word in an array.
	 * 
	 * @param words array of words to be number swapped
	 * @return a string representation of the swapped word array
	 */
	public static String numberSwapper(String[] words)
	{
		String answer = "";
		for(String word : words)
		{
			answer += word.substring(word.length() - 1) + 
					word.substring(1, word.length() - 1) + 
						word.substring(0, 1) + " ";
		}
		return answer;
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
