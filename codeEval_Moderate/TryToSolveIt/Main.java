package TryToSolveIt;

import java.io.*;
import java.util.*;

/**
 * Try To Solve It/ Challenge 226 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/226/
 * 
 * @author Joe Stover
 * @version June 18, 2016
 */
public class Main 
{	
	public static final Map<Character, Character> DECRYPT_MAP = 
			new HashMap<Character, Character>();
	static
	{
		DECRYPT_MAP.put('a', 'u');
		DECRYPT_MAP.put('b', 'v');
		DECRYPT_MAP.put('c', 'w');
		DECRYPT_MAP.put('d', 'x');
		DECRYPT_MAP.put('e', 'y');
		DECRYPT_MAP.put('f', 'z');
		DECRYPT_MAP.put('g', 'n');
		DECRYPT_MAP.put('h', 'o');
		DECRYPT_MAP.put('i', 'p');
		DECRYPT_MAP.put('j', 'q');
		DECRYPT_MAP.put('k', 'r');
		DECRYPT_MAP.put('l', 's');
		DECRYPT_MAP.put('m', 't');
		DECRYPT_MAP.put('u', 'a');
		DECRYPT_MAP.put('v', 'b');
		DECRYPT_MAP.put('w', 'c');
		DECRYPT_MAP.put('x', 'd');
		DECRYPT_MAP.put('y', 'e');
		DECRYPT_MAP.put('z', 'f');
		DECRYPT_MAP.put('n', 'g');
		DECRYPT_MAP.put('o', 'h');
		DECRYPT_MAP.put('p', 'i');
		DECRYPT_MAP.put('q', 'j');
		DECRYPT_MAP.put('r', 'k');
		DECRYPT_MAP.put('s', 'l');
		DECRYPT_MAP.put('t', 'm');
		
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
				char[] array = line.toCharArray();
				line = "";
				for(char letter : array)
				{
					line += DECRYPT_MAP.get(letter);
				}
				System.out.println(line);
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
