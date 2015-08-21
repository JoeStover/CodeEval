package CashRegister;

import java.io.*;
import java.util.HashMap;

/**
 * Cash Register / Challenge 54 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/54/
 * 
 * @author Joe Stover
 * @version Dec 04, 2014
 */
public class Main 
{
	// constant pairs value to currency
	static final HashMap<Integer, String> CHANGE_MAP = 
			new HashMap<Integer, String>();
	static
	{
		CHANGE_MAP.put(1, "PENNY");
		CHANGE_MAP.put(5, "NICKEL");
		CHANGE_MAP.put(10, "DIME");
		CHANGE_MAP.put(25, "QUARTER");
		CHANGE_MAP.put(50, "HALF DOLLAR");
		CHANGE_MAP.put(100, "ONE");
		CHANGE_MAP.put(200, "TWO");
		CHANGE_MAP.put(500, "FIVE");
		CHANGE_MAP.put(1000, "TEN");
		CHANGE_MAP.put(2000, "TWENTY");
		CHANGE_MAP.put(5000, "FIFTY");
		CHANGE_MAP.put(10000, "ONE HUNDRED");
	}
	// constant holds all change options
	final static int[] CHANGE_OPTIONS = 
		{1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
	
	public static void main(String[] args) throws IOException
	{		
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(";");
				String answer = "";
				int cost = (int) (Double.parseDouble(parts[0]) * 100);
				int payment = (int) (Double.parseDouble(parts[1]) * 100);
				int change = payment - cost;
				if(change < 0)
				{
					answer = "ERROR ";
				}
				else if(change == 0)
				{
					answer = "ZERO ";
				}
				else
				{
					int counter = CHANGE_OPTIONS.length - 1;
						while(change > 0)
						{
							if(CHANGE_MAP.containsKey(change))
							{
								answer += CHANGE_MAP.get(change) + " ";
								change -= change;
							}
							else if(change > CHANGE_OPTIONS[counter])
							{
								answer += 
								    CHANGE_MAP.get(CHANGE_OPTIONS[counter]) + ",";
								change -= CHANGE_OPTIONS[counter];
							}
							else
							{
								counter--;
							}	
						}
					}
				System.out.println(answer.substring(0, answer.length() -1));
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
