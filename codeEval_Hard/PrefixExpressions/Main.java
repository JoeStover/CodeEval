package PrefixExpressions;

import java.io.*;
import java.util.Stack;

/**
 * Prefix Expressions / Challenge 7 / Hard
 * 
 * https://www.codeeval.com/open_challenges/7/
 * 
 * @author Joe Stover
 * @version Nov 25, 2014
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
				String[] parts = line.split(" ");
				Stack<String> operators = new Stack<String>();
				Stack<Double> numbers = new Stack<Double>();
				for(int i = parts.length - 1; i >= 0; i--)
				{
					if(parts[i].matches("-?[0-9]+"))
					{
						numbers.push(Double.parseDouble(parts[i]));
					}
					else if(parts[i].equals("*"))
					{
						numbers.push(numbers.pop() * numbers.pop());
					}
					else if(parts[i].equals("/"))
					{
						numbers.push(numbers.pop() / numbers.pop());
					}
					else if(parts[i].equals("+"))
					{
						numbers.push(numbers.pop() + numbers.pop());
					}
				}
				System.out.println(numbers.pop().intValue());
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