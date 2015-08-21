package RomanAndArabic;

import java.io.*;
import java.util.*;

/**
 * Roman and Arabic / Challenge 150 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/150/
 * 
 * @author Joe Stover
 * @version Feb 07, 2015
 */
public class Main 
{
	static final HashMap<Character, Integer> ROME_TO_DEC = 
			new HashMap<Character, Integer>();
	static
	{
		ROME_TO_DEC.put('I', 1);
		ROME_TO_DEC.put('V', 5);
		ROME_TO_DEC.put('X', 10);
		ROME_TO_DEC.put('L', 50);
		ROME_TO_DEC.put('C', 100);
		ROME_TO_DEC.put('D', 500);
		ROME_TO_DEC.put('M', 1000);
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
				int total = 0;
				char[] aromatic = line.toCharArray();
				for(int i = 0; i < aromatic.length; i += 2)
				{
					int temp = Character.getNumericValue(aromatic[i]) * 
							ROME_TO_DEC.get(aromatic[i + 1]);
					if(i + 3 < aromatic.length)
					{
						if(ROME_TO_DEC.get(aromatic[i + 3]) > 
							ROME_TO_DEC.get(aromatic[i + 1]))
						{
							total -= temp;
						}
						else
						{
							total += temp;
						}
					}
					else
					{
						total += temp;
					}					
				}
				System.out.println(total);
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
