package GronsfeldCipher;

import java.io.*;
import java.util.*;

/**
 * Gronsfeld Cipher / Challenge 181 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/181/
 * 
 * @author Joe Stover
 * @version Feb 02, 2015
 */
public class Main 
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		String alphabet = " !\"#$%&'()*+,-./0123456789:<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		ArrayList<String> cipher = new ArrayList<String>();
		for(int i = 0; i < alphabet.length(); i++)
		{
			cipher.add(alphabet.substring(i, i + 1));
		}
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String phrase = "";
				String[] parts = line.split(";");
				String message = parts[1];
				String key = parts[0];
				// fill up key if shorter than message
				while(key.length() < message.length())
				{
					key += key;
				}
				for(int i = 0; i < message.length(); i++)
				{
					int shift = cipher.indexOf(message.substring(i, i + 1)) - 
							Integer.parseInt(key.substring(i, i + 1));
					if (shift >= 0)
						phrase += cipher.get(shift);
					else
						phrase += cipher.get(cipher.size() + shift);
				}
				System.out.println(phrase);
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
