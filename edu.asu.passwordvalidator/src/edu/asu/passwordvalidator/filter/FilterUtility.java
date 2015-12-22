package edu.asu.passwordvalidator.filter;

import java.util.List;
import java.util.Random;

public class FilterUtility {


	public static boolean contain(List<String> words, String password)
	{
		boolean isContain = false;
		for(int i = 0; i < words.size(); i++)
		{
			if(words.get(i).equalsIgnoreCase(password))
			{
				isContain = true;
				break;
			}
		}
		return isContain;
	}

	public static String randomSalt(List<String> words)
	{
		Random random = new Random();
		return words.get(random.nextInt(words.size()));
	}

}
