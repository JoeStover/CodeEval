package MorseCode;

import java.io.*;
import java.util.HashMap;

/**
 * Morse Code / Challenge 116 / Easy
 * 
 * https://www.codeeval.com/open_challenges/116/
 * 
 * @author Joe Stover
 * @version Nov 08, 2014
 */
public class Main 
{
	final static HashMap<String, String> KEY =
			new HashMap<String, String>();
	public static void main (String [] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		generateMorseKey();
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] words = line.split("  ");
				for(String word : words)
				{
					String[] letters = word.split(" ");
					for (String letter: letters)
					{
						System.out.print(KEY.get(letter));
					}
					System.out.print(" ");
				}
				System.out.println("");
			}
		}
		finally
		{
			reader.close();
		}		
	}
	public static void generateMorseKey()
	{
		KEY.put(".-", "A");
		KEY.put("-...", "B");
		KEY.put("-.-.", "C");
		KEY.put("-..", "D");
		KEY.put(".", "E");
		KEY.put("..-.", "F");
		KEY.put("--.", "G");
		KEY.put("....", "H");
		KEY.put("..", "I");
		KEY.put(".---", "J");
		KEY.put("-.-", "K");
		KEY.put(".-..", "L");
		KEY.put("--", "M");
		KEY.put("-.", "N");
		KEY.put("---", "O");
		KEY.put(".--.", "P");
		KEY.put("--.-", "Q");
		KEY.put(".-.", "R");
		KEY.put("...", "S");
		KEY.put("-", "T");
		KEY.put("..-", "U");
		KEY.put("...-", "V");
		KEY.put(".--", "W");
		KEY.put("-..-", "X");
		KEY.put("-.--", "Y");
		KEY.put("--..", "Z");
		// numbers
		KEY.put(".----", "1");
		KEY.put("..---", "2");
		KEY.put("...--", "3");
		KEY.put("....-", "4");
		KEY.put(".....", "5");
		KEY.put("-....", "6");
		KEY.put("--...", "7");
		KEY.put("---..", "8");
		KEY.put("----.", "9");
		KEY.put("-----", "0");
		// punctuation
		KEY.put("--..--", ",");
		KEY.put("---...", ":");
		KEY.put("..--..", "?");
		KEY.put(".----.", "'");
		KEY.put("-....-", "-");
		KEY.put("-..-.", "/");
		KEY.put("-.--.-", "\"");
		KEY.put("", "");
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
