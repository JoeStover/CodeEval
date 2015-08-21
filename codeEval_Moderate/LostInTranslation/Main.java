package LostInTranslation;

import java.io.*;
import java.util.*;

/**
 * Lost in Translation / Challenge 121 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/121/
 * 
 * @author Joe Stover
 * @version Mar 01, 2015
 */
public class Main 
{
	static final HashMap<String, String> MAP = 
			new HashMap<String, String>();
	static
	{
		// setup map based on the CodeEval samples
		MAP.put(" ", " ");
		MAP.put("a", "y");
		MAP.put("b", "h");
		MAP.put("c", "e");
		MAP.put("d", "s");
		MAP.put("e",  "o");
		MAP.put("f", "c");
		MAP.put("g", "v");
		MAP.put("h", "x");
		MAP.put("i", "d");
		MAP.put("j", "u");
		MAP.put("k", "i");
		MAP.put("l", "g");
		MAP.put("m", "l");
		MAP.put("n", "b");
		MAP.put("o", "k");
		MAP.put("p", "r");
		MAP.put("q", "z");
		MAP.put("r", "t");
		MAP.put("s", "n");
		MAP.put("t", "w");
		MAP.put("u", "j");
		MAP.put("v", "p");
		MAP.put("w", "f");
		MAP.put("x", "m");
		MAP.put("y", "a");
		MAP.put("z", "q");
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				for(int i = 0; i < line.length(); i++)
				{
					System.out.print(MAP.get(line.substring(i, i + 1)));
				}
				System.out.println();
			}
			reader.close();
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
