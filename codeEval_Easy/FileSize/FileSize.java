package FileSize;

import java.io.File;

/**
 * File Size / Challenge 26 / Easy
 * 
 * https://www.codeeval.com/open_challenges/26/
 * 
 * @author Joe Stover
 * @version Nov 13, 2014
 */
public class FileSize 
{
	public static void main(String[] args)
	{
		File file = new File(args[0]);
		System.out.println(file.length());
	}
}
