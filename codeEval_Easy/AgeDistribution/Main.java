package AgeDistribution;

import java.io.*;

/**
 * Age Distribution / Challenge 152 / Easy
 * 
 * https://www.codeeval.com/open_challenges/152/
 * 
 * @author Joe Stover
 * @version Nov 08, 2014
 *
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
				int age = Integer.parseInt(line);
				if(age >= 0 && age <= 2)
				{
					System.out.println("Still in Mama's arms");
				}
				else if(age == 3 || age == 4)
				{
					System.out.println("Preschool Maniac");
				}
				else if(age > 4 && age <= 11)
				{
					System.out.println("Elementary school");
				}
				else if(age > 11 && age <= 14)
				{
					System.out.println("Middle school");
				}
				else if(age > 14 && age <= 18)
				{
					System.out.println("High school");
				}
				else if(age > 18 && age <= 22)
				{
					System.out.println("College");
				}
				else if(age > 22 && age <= 65)
				{
					System.out.println("Working for the man");
				}
				else if(age > 65 && age <= 100)
				{
					System.out.println("The Golden Years");
				}
				else
				{
					System.out.println("This program is for humans");
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
	 * @param args array of arguments passed to Main. If not empty, check
	 * 		  first index for an input file name.
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
