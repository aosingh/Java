package edu.asu.passwordvalidator.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.asu.passwordvalidator.model.PasswordValidatorConstants.PasswordValidatorRule;

public class PasswordFilterDAO {

	
	private static PasswordFilterDAO passwordFilterDAO = null;
	
	public static PasswordFilterDAO getInstance()
	{
		if(passwordFilterDAO == null)
		{
			passwordFilterDAO = new PasswordFilterDAO();
		}
		return passwordFilterDAO;
	}

	private static Log logger = LogFactory.getLog(PasswordFilterDAO.class);

	public List<String> getListofWords(PasswordValidatorRule passwordValidator)
	{
		logger.info("Entered method to get the Word Data List");
		List<String> words = new ArrayList<String>();
		String fileName = null;
		switch(passwordValidator)
		{
		case PROPRIETORY_WORDS:
			fileName = "PropreitoryWords.txt";
			break;
		case OFFENSIVE_WORDS:
			fileName = "OffensiveWords.txt";
			break;
		case SALTING:
			fileName = "SaltWords.txt";
			break;
		}
		words = FilterWordsReader.readLineFromFile(fileName);
		logger.info("Exit method after getting the Word Data List");
		return words;

	}

}
