package DataRecovery;

import java.io.*;
import java.util.*;

/**
 * Data Recovery / Challenge 140 / Easy
 * 
 * https://www.codeeval.com/open_challenges/140/
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
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
				// break out the rules and words
				String[] parts = line.split(";");
				String[] words = parts[0].split(" ");
				String[] sequence = parts[1].split(" ");
				// make a map to pair sequence with words 
				// (note there is one more word than there is sequence)
				HashMap<String, String> cipher = new HashMap<String, String>();
				// get the sum so we can calculate missing numbers based on words.length vs sequence
				int sum = words.length * (words.length + 1) / 2;
				// move through the sequence and words based on sequence length
				// (use the sum to get the missing number if one exists)
				for (int i = 0; i < sequence.length; i++)
				{
					// pair words in the map
					cipher.put(sequence[i], words[i]);
					// determine what we're missing
					sum -= Integer.parseInt(sequence[i]);
				}
				// add our last word
				cipher.put(sum + "", words[words.length - 1]);
				// now read it out
				for (int i = 1; i <= words.length; i++)
				{
					System.out.print(cipher.get(i +"") + " ");
				}
				System.out.println("");
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
