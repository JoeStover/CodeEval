package BrokenLcd;

import java.io.*;
import java.util.*;

/**
 * Broken LCD / Challenge 179 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/179/
 * 
 * @author Joe Stover
 * @version Jan 24, 2015
 */
public class Main 
{
	// map constant to match binary representations with a given number
	static final HashMap<String, String> BINARY_REPS = new HashMap<String, String>();
	static
	{
		BINARY_REPS.put("0", "11111100");
		BINARY_REPS.put("1", "01100000");
		BINARY_REPS.put("2", "11011010");
		BINARY_REPS.put("3", "11110010");
		BINARY_REPS.put("4", "01100110");
		BINARY_REPS.put("5", "10110110");
		BINARY_REPS.put("6", "10111110");
		BINARY_REPS.put("7", "11100000");
		BINARY_REPS.put("8", "11111110");
		BINARY_REPS.put("9", "11110110");
		BINARY_REPS.put("0.", "11111101");
		BINARY_REPS.put("1.", "01100001");
		BINARY_REPS.put("2.", "11011011");
		BINARY_REPS.put("3.", "11110011");
		BINARY_REPS.put("4.", "01100111");
		BINARY_REPS.put("5.", "10110111");
		BINARY_REPS.put("6.", "10111111");
		BINARY_REPS.put("7.", "11100001");
		BINARY_REPS.put("8.", "11111111");
		BINARY_REPS.put("9.", "11110111");
	}
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(";");
				char[] number = parts[1].toCharArray();
				String[] lights = parts[0].split(" ");
				// need to break our number into individual numbers (String[])
				// (append "." to prev num, if it exists)
				ArrayList<String> digits = new ArrayList<String>();
				for(int i = 0; i < number.length; i++)
				{
					if(Character.isDigit(number[i]))
					{
						digits.add(Character.toString(number[i]));
					}
					else
					{
						// if it isn't a digit, it is ".", append to last index
						digits.set(digits.size() - 1, 
								digits.get(digits.size() - 1) + number[i]);
						
					}
				}
				// need to append the '.' if it was not present at end of array
				if(!parts[1].contains("."))
				{
					digits.set(digits.size() - 1, 
							digits.get(digits.size() - 1) + ".");
				}
				System.out.println(Main.canDisplayNumber(digits, lights));	
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Takes the states of a single light on a LCD screen as well as a
	 * digit to be displayed. This is checked against a map of binary 
	 * representations to see if that number can be displayed on this light.
	 * 
	 * @param digit that must be displayed at this state
	 * @param light to be checked based on each binary segment in the String
	 * @return true if the digit can be displayed on this segment, 
	 *         false otherwise
	 */
	public static boolean canDisplayDigit(String digit, String light)
	{
		// toggle to show if number can be displayed on this segment
		boolean canDisplay = true;
		
		// get binary rep of the digit, convert bin rep and segment to 
		// char arrays to check if it can be displayed
		char[] binaryRep = BINARY_REPS.get(digit).toCharArray();
		char[] segment = light.toCharArray();
		int count = 0;
		// iterate through 8 bit binary until you prove it won't work
		while(count < 8 && canDisplay)
		{
			// only care if 0, as that segment CAN'T toggle
			if(segment[count] == '0')
			{
				// check if the binary rep at this point has to be on
				// and set canDisplay
				canDisplay = segment[count] == binaryRep[count];
			}
			count++;
		}		
		return canDisplay;
	}
	/**
	 * Takes a number (as an array of digits) and checks it against an array
	 * of lights in an LCD screen.
	 * 
	 * @param digits array that is to be displayed
	 * @param lights in an LCD to check against to see if they can 
	 *        display each digit based on working segments
	 * @return 1 if the digits can be displayed, 
	 *         0 if LCD is too broken for this number to display
	 */
	public static int canDisplayNumber(ArrayList<String> digits, String[] lights)
	{
		int canDisplayNumber = 0;
		// need nested for's here because the start is arbitrary, so we need to test 
		// a shifting sequence from beginning of lights to end of lights for all
		// digits in array
		int shift = lights.length - digits.size();
		for(int i = 0; i <= shift; i++)
		{
			int count = 0;
			for(int j = 0; j < digits.size(); j++)
			{
				if(Main.canDisplayDigit(digits.get(j), lights[j + i]))
				{
					count++;
				}
			}
			if(count == digits.size())
			{
				canDisplayNumber = 1;
			}
		}
		return canDisplayNumber;
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
