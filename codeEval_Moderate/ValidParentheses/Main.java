package ValidParentheses;

/**
 * Valid Parentheses / Challenge 68 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/68/
 * 
 * @author Joe Stover
 * @version Mar 04, 2015
 */
import java.io.*;
import java.util.*;

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
				System.out.println(hasValidParens(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Checks if the passed in string contains valid (matching) parentheses.
	 * 
	 * @param line string to be checked
	 * @return true if all parentheses in this line match up correctly,
	 *         false otherwise
	 */
	public static String hasValidParens(String line)
	{
		String isValid = "True";
		Stack<Character> open = new Stack<Character>();
		char[] parens = line.toCharArray();
		for(char paren : parens)
		{
			if(isOpenParen(paren))
			{
				open.push(paren);
			}
			else if(open.isEmpty() || !isMatchingParens(open.pop(), paren))
			{
				isValid = "False";
			}
		}
		if(!open.isEmpty())
		{
			isValid = "False";
		}
		return isValid;
	}
	/**
	 * Checks if characters are matching parentheses.
	 * 
	 * @param open   paren to check
	 * @param closed paren to check
	 * @return true if open and close parens match, false otherwise
	 */
	public static boolean isMatchingParens(char open, char closed)
	{
		if(open == '[') 
		{
            return closed == ']'; 
        } 
		else if(open == '{') 
		{
            return closed == '}';
        } 
		else 
		{
            return closed == ')';
        }
	}
	/**
	 * Verifies that a character is an opening parenthesis.
	 * 
	 * @param inChar the char to be checked
	 * @return true if an open paren, false otherwise
	 */
	public static boolean isOpenParen(char inChar)
	{
		return (inChar == '{' || inChar == '[' || inChar == '(');
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
