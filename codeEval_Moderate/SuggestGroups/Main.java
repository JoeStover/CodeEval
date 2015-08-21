package SuggestGroups;

import java.io.*;
import java.util.*;

/**
 * Suggest Groups / Challenge 165 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/165/
 * 
 * @author Joe Stover
 * @version Mar 10, 2015
 */
public class Main
{
	public static void main(String[] args) throws IOException 
	{
		// hold a list of users
		ArrayList<String> userList = new ArrayList<String>();
		// maps a user to a list of their friends
		LinkedHashMap<String, List<String>> friends = 
				new LinkedHashMap<String, List<String>>();
		// maps a user to a list of their groups
		LinkedHashMap<String, List<String>> groups = 
				new LinkedHashMap<String, List<String>>();
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(":");
				// collect each user
				userList.add(parts[0]);
				// load this user into the friends map along with their friends
				friends.put(parts[0], Arrays.asList(parts[1].split(",")));
				if(parts.length > 2)
				{
					// load activities into the groups map for this user if
					// they have activities
					groups.put(parts[0], Arrays.asList(parts[2].split(",")));
				}			
			}
			// sort list alphabetically
			Collections.sort(userList);
			// work through each user and get their participation lists
			for(String user : userList)
			{
				String temp = getParticipationList(user, friends, groups);
				if(!temp.isEmpty())
				{
					System.out.println(user + ":" + temp);
				}
			}			
		} 
		finally
		{
			reader.close();
		}
	}
	/**
	 * Creates a participation list for a specific person based on
	 * a passed in friendsList and groupsList.
	 * 
	 * @param name the person for whom a participation list is generated
	 * @param friendsList HashMap that links a person to an ArrayList of their
	 *                    friends
	 * @param groupsList  HashMap that links a person to an ArrayList of groups
	 *                    they are in
	 * @return a String participation list that suggests groups for a user
	 *         in alphabetical order
	 */
	public static String getParticipationList(String name, HashMap<String, 
			List<String>> friendsList, HashMap<String, List<String>> groupsList)
	{
		String result = "";
		// holds groups suggested by friends
		ArrayList<String> suggestGroups = new ArrayList<String>();
		// existing groups for this name and this name's total friends
		int totalFriends = 0;
		List<String> currentGroups = new ArrayList<String>();
		// holds existing groups so we don't duplicate
		if(groupsList.get(name) != null)
		{
			currentGroups = groupsList.get(name);
		}		
		LinkedHashMap<String, Integer> friendsGroups = 
				new LinkedHashMap<String, Integer>(); 
		// load a map with groups that friends are in (keys)
		// and how many friends per group (values)
		if(friendsList.get(name) != null && 
				!friendsList.get(name).isEmpty())
		{
			totalFriends = friendsList.get(name).size();
			for(String friendName : friendsList.get(name))
			{
				if(groupsList.get(friendName) != null &&
						!groupsList.get(friendName).isEmpty())
				for(String group : groupsList.get(friendName))
				{
					if(friendsGroups.get(group) == null)
					{
						friendsGroups.put(group, 1);
					}
					else
					{
						friendsGroups.put(group, friendsGroups.get(group) + 1);
					}
				}
			}
		}
		for (Map.Entry<String, Integer> entry : friendsGroups.entrySet())
		{
		    if(!currentGroups.contains(entry.getKey()) && 
		    		((double)entry.getValue()) / totalFriends >= .50)
		    {
		    	suggestGroups.add(entry.getKey());
		    }
		}
		Collections.sort(suggestGroups);
		for(String group : suggestGroups)
		{
			result += group + ",";
		}
		if(!result.isEmpty())
		{
			result = result.substring(0, result.length() - 1);
		}
		return result;
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
