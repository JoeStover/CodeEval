package TextToNumber;

import java.io.*;
import java.util.*;

/**
 * Text to Number / Challenge 110 / Hard
 * 
 * https://www.codeeval.com/open_challenges/110/
 * 
 * @author Joe Stover
 * @version Mar 30, 2015
 */
public class Main 
{
	// holds our conversion table
	private static final HashMap<String, Integer> textToNumber = 
			new HashMap<String, Integer>();
	static
	{	// loads our static map
		// used in multiplication
		textToNumber.put("hundred", 100);
		textToNumber.put("thousand", 1000);
		textToNumber.put("million", 1000000);
		// used in addition
		textToNumber.put("zero", 0);
		textToNumber.put("one", 1);
		textToNumber.put("two", 2);
		textToNumber.put("three", 3);
		textToNumber.put("four", 4);
		textToNumber.put("five", 5);
		textToNumber.put("six", 6);
		textToNumber.put("seven", 7);
		textToNumber.put("eight", 8);
		textToNumber.put("nine", 9);
		textToNumber.put("ten", 10);
		textToNumber.put("eleven", 11);
		textToNumber.put("twelve", 12);
		textToNumber.put("thirteen", 13);
		textToNumber.put("fourteen", 14);
		textToNumber.put("fifteen", 15);
		textToNumber.put("sixteen", 16);
		textToNumber.put("seventeen", 17);
		textToNumber.put("eighteen", 18);
		textToNumber.put("nineteen", 19);
		textToNumber.put("twenty", 20);
		textToNumber.put("thirty", 30);
		textToNumber.put("forty", 40);
		textToNumber.put("fifty", 50);
		textToNumber.put("sixty", 60);
		textToNumber.put("seventy", 70);
		textToNumber.put("eighty", 80);
		textToNumber.put("ninety", 90);
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
				String[] numbers = line.split(" ");
				System.out.println(convertToNumber(numbers));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Converts an array of strings representing a number into its numeric
	 * representation.
	 * 
	 * @param numbers array of strings to be converted
	 * @return the integer representation of the number
	 */
	public static int convertToNumber(String[] numbers)
	{
		int total = 0;
		Stack<Integer> add = new Stack<Integer>();
		// flag to make our number negative in the end if needed
		boolean isNegative = false;
		for(String number : numbers)
		{
			// if it isn't in the map, must be "-"
			if(textToNumber.get(number) == null)
			{
				isNegative = true;
			}
			else
			{
				int num = textToNumber.get(number);
				if(!isThousands(num) && !isHundreds(num))
				{
					add.push(num);
				}
				else if(isHundreds(num))
				{
					int temp = 0;
					while(!add.isEmpty())
					{
						temp += add.pop();
					}
					temp *= 100;
					add.push(temp);
				}
				else
				{
					int temp = 0;
					while(!add.isEmpty())
					{
						temp += add.pop();
					}
					temp *= num;
					total += temp;
				}
			}
		}
		while(!add.isEmpty())
		{
			total += add.pop();
		}
		if(isNegative)
		{
			total *= -1;
		}
		return total;
	}
	/**
	 * Checks if an int is either 1,000 or 1,000,000 place.
	 * 
	 * @param number to be checked
	 * @return true if either 1000 or 1,000,000, false otherwise
	 */
	public static boolean isThousands(int number)
	{
		return (number == 1000 || number == 1000000);
	}
	/**
	 * Verifies number is in 100's
	 * 
	 * @param number to be checked
	 * @return true if number is 100's, false otherwise
	 */
	public static boolean isHundreds(int number)
	{
		return number == 100;
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
