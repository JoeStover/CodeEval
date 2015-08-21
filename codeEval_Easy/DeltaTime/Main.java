package DeltaTime;

import java.io.*;

/**
 * Delta Time / Challenge 166 / Easy
 * 
 * https://www.codeeval.com/open_challenges/166/
 * 
 * @author Joe Stover
 * @version Nov 05, 2014
 */
public class Main 
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				// get times
				String[] times = line.split(" ");
				String firstTime = times[0];
				String secondTime = times[1];
				// get first in seconds
				String[] firstTimeParts = firstTime.split(":");
				int firstTimeHours = Integer.parseInt(firstTimeParts[0]);
				int firstTimeMins = Integer.parseInt(firstTimeParts[1]);
				int firstTimeSecs = Integer.parseInt(firstTimeParts[2]);
				int firstTotalSecs = (firstTimeHours * 60 * 60) + 
						(firstTimeMins * 60) + (firstTimeSecs);
				// get second in seconds
				String[] secondTimeParts = secondTime.split(":");
				int secondTimeHours = Integer.parseInt(secondTimeParts[0]);
				int secondTimeMins = Integer.parseInt(secondTimeParts[1]);
				int secondTimeSecs = Integer.parseInt(secondTimeParts[2]);
				int secondTotalSecs = (secondTimeHours * 60 * 60) + 
						(secondTimeMins * 60) + (secondTimeSecs);
				// get time difference
				int seconds = Math.abs(firstTotalSecs - secondTotalSecs);
				// convert diff to a string
				int mins = seconds / 60;
				seconds = seconds % 60;
				int hours = mins / 60;
				mins = mins % 60;
				seconds = seconds % 60;
				// leading 0's
				String inHours = "";
				if (hours < 10)
				{
					inHours = "0" + hours;
				}
				else
				{
					inHours = inHours + hours;
				}
				String inMins = "";
				if (mins < 10)
				{
					inMins = "0" + mins;
				}
				else
				{
					inMins = inMins + mins;
				}
				String inSeconds = "";
				if (seconds < 10)
				{
					inSeconds = "0" + seconds;
				}
				else
				{
					inSeconds = inSeconds + seconds;
				}
				System.out.println(inHours +":" + inMins + ":" + inSeconds);
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
