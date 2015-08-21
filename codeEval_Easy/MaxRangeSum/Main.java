package MaxRangeSum;

import java.io.*;

/**
 * Max Range Sum / Challenge 186 / Easy
 * 
 * https://www.codeeval.com/open_challenges/186/
 * 
 * @author Joe Stover
 * @version Mar 06, 2015
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
				String[] parts = line.split(";");
				int days = Integer.parseInt(parts[0]);
				String[] markFlux = parts[1].split(" ");
				int netGains = 0;
				for(int i = 0; i <= markFlux.length - days; i++)
				{
					int tempGains = 0;
					for(int j = i; j < days + i; j++)
					{
						tempGains += Integer.parseInt(markFlux[j]);
					}
					netGains = (tempGains > netGains) ? tempGains : netGains;
				}
				System.out.println(netGains);
			}
			reader.close();
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
