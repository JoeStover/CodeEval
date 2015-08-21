package Pangrams;

import java.io.*;
import java.util.*;

/**
 * Pangrams / Challenge 37 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/37/
 * 
 * @author Joe Stover
 * @version Jan 13, 2015
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
				LinkedHashSet<Character> alphabet = new LinkedHashSet<Character>();
				alphabet.add('a');
				alphabet.add('b');
				alphabet.add('c');
				alphabet.add('d');
				alphabet.add('e');
				alphabet.add('f');
				alphabet.add('g');
				alphabet.add('h');
				alphabet.add('i');
				alphabet.add('j');
				alphabet.add('k');
				alphabet.add('l');
				alphabet.add('m');
				alphabet.add('n');
				alphabet.add('o');
				alphabet.add('p');
				alphabet.add('q');
				alphabet.add('r');
				alphabet.add('s');
				alphabet.add('t');
				alphabet.add('u');
				alphabet.add('v');
				alphabet.add('w');
				alphabet.add('x');
				alphabet.add('y');
				alphabet.add('z');
				char[] phrase = line.toCharArray();
				for(char letter : phrase)
				{
					alphabet.remove(Character.toLowerCase(letter));
				}
				if(alphabet.isEmpty())
				{
					System.out.print("NULL");
				}
				else
				{
					Iterator<Character> iter = alphabet.iterator();
					while(iter.hasNext())
					{
						System.out.print(iter.next());
					}
				}
				System.out.println();
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
