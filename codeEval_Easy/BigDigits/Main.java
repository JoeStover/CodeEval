package BigDigits;

import java.io.*;
/**
 * Big Digits / Challenge 163 / Easy
 * 
 * https://www.codeeval.com/open_challenges/163/
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
 *
 */
public class Main 
{	
	// constant to hold our gfx representations
	static final String[][] NUMBERS = new String[6][10];

	public static void main(String[] args) throws IOException
	{			
		loadNumbers();
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				// iterator per row
				for (int i = 0; i < 6; i++)
				{
					// now go through the line and create our ascii
					for (int j = 0; j < line.length(); j++ )
					{
						if(Character.isDigit(line.charAt(j)))
						{
							int temp = Character.getNumericValue(line.charAt(j));
							System.out.print(NUMBERS[i][temp]);
						}
					}
					System.out.println("");
				}
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
	/**
	 * Loads up our NUMBERS constant with ascii gfx for digits
	 */
	public static void loadNumbers()
	{
		// zero
		NUMBERS[0][0] = "-**--";
		NUMBERS[1][0] = "*--*-";
		NUMBERS[2][0] = "*--*-";
		NUMBERS[3][0] = "*--*-";
		NUMBERS[4][0] = "-**--";
		NUMBERS[5][0] = "-----";
		// one
		NUMBERS[0][1] = "--*--";
		NUMBERS[1][1] = "-**--";
		NUMBERS[2][1] = "--*--";
		NUMBERS[3][1] = "--*--";
		NUMBERS[4][1] = "-***-";
		NUMBERS[5][1] = "-----";
		// two
		NUMBERS[0][2] = "***--";
		NUMBERS[1][2] = "---*-";
		NUMBERS[2][2] = "-**--";
		NUMBERS[3][2] = "*----";
		NUMBERS[4][2] = "****-";
		NUMBERS[5][2] = "-----";
		// three
		NUMBERS[0][3] = "***--";
		NUMBERS[1][3] = "---*-";
		NUMBERS[2][3] = "-**--";
		NUMBERS[3][3] = "---*-";
		NUMBERS[4][3] = "***--";
		NUMBERS[5][3] = "-----";
		// four
		NUMBERS[0][4] = "-*---";
		NUMBERS[1][4] = "*--*-";
		NUMBERS[2][4] = "****-";
		NUMBERS[3][4] = "---*-";
		NUMBERS[4][4] = "---*-";
		NUMBERS[5][4] = "-----";
		// five
		NUMBERS[0][5] = "****-";
		NUMBERS[1][5] = "*----";
		NUMBERS[2][5] = "***--";
		NUMBERS[3][5] = "---*-";
		NUMBERS[4][5] = "***--";
		NUMBERS[5][5] = "-----";
		// six
		NUMBERS[0][6] = "-**--";
		NUMBERS[1][6] = "*----";
		NUMBERS[2][6] = "***--";
		NUMBERS[3][6] = "*--*-";
		NUMBERS[4][6] = "-**--";
		NUMBERS[5][6] = "-----";
		// seven
		NUMBERS[0][7] = "****-";
		NUMBERS[1][7] = "---*-";
		NUMBERS[2][7] = "--*--";
		NUMBERS[3][7] = "-*---";
		NUMBERS[4][7] = "-*---";
		NUMBERS[5][7] = "-----";
		// eight
		NUMBERS[0][8] = "-**--";
		NUMBERS[1][8] = "*--*-";
		NUMBERS[2][8] = "-**--";
		NUMBERS[3][8] = "*--*-";
		NUMBERS[4][8] = "-**--";
		NUMBERS[5][8] = "-----";
		// nine
		NUMBERS[0][9] = "-**--";
		NUMBERS[1][9] = "*--*-";
		NUMBERS[2][9] = "-***-";
		NUMBERS[3][9] = "---*-";
		NUMBERS[4][9] = "-**--";
		NUMBERS[5][9] = "-----";
	}
}
