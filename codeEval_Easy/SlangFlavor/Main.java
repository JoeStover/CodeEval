package SlangFlavor;

import java.io.*;

/**
 * Slang Flavor / Challenge 174 / Easy
 * 
 * https://www.codeeval.com/open_challenges/174/
 * 
 * @author Joe Stover
 * @version Dec 17, 2014
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		int chooser = -1;
		String phrase = "";
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				StringBuilder answer = new StringBuilder();
				for(int i = 0; i < line.length(); i++)
				{
					if(line.charAt(i) == '.' ||
							line.charAt(i) == '!' ||
								line.charAt(i) == '?')
					{
						switch (chooser % 16)
						{
							case 0: phrase = ", yeah!";
								break;
							case 2: phrase = ", this is crazy, I tell ya.";
								break;
							case 4: phrase = ", can U believe this?";
								break;
							case 6: phrase = ", eh?";
								break;
							case 8: phrase = ", aw yea.";
								break;
							case 10: phrase = ", yo.";
								break;
							case 12: phrase = "? No way!";
								break;
							case 14: phrase = ". Awesome!";
								break;
							default: phrase = line.charAt(i) + "";
		                     break;
						}
						answer.append(phrase);
						chooser++;
					}
					else
					{
						answer.append(line.charAt(i));
					}
				}
				System.out.println(answer);
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
