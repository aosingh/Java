package edu.asu.passwordvalidator.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.*;

public class FilterWordsReader {

	private static Log logger = LogFactory.getLog(FilterWordsReader.class);

	public static List<String> readLineFromFile(String fileName)
	{
		List<String> words = new ArrayList<String>();
		String line="";
		try
		{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(fileReader);
			while((line=buffer.readLine()) != null)
			{
				logger.info("The line is"+line);
				words.add(line);
			}
			
			buffer.close();

		}
		catch(FileNotFoundException fe)
		{
			logger.error(fe);
		}
		catch(IOException ex)
		{
			logger.error(ex);
		}
		return words;
	}

}

