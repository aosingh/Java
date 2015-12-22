package edu.asu.passwordvalidator.filter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.asu.passwordvalidator.dao.PasswordFilterDAO;
import edu.asu.passwordvalidator.model.PasswordValidatorConstants.PasswordValidatorRule;

public class ProprietoryWordFilter implements Filter {

	private static Log logger = LogFactory.getLog(ProprietoryWordFilter.class);

	
	@Override
	public String doFilter(String password) 
	{
		logger.info("In method ProprietoryWordFilter");
		if(FilterUtility.contain(getListOfProprietoryWords(), password))
		{
			logger.info("The password"+password+"constains Propreitory words");
			password = "";
		}
		return password;
	
	}

	@Override
	public String postProcessing(String message) 
	{
		return message;
	}
	
	public List<String> getListOfProprietoryWords()
	{
		logger.info("In method getListOfProprietoryWords");
		List<String> words = PasswordFilterDAO.getInstance().getListofWords(PasswordValidatorRule.PROPRIETORY_WORDS);
		logger.info("The size of Proprietory words list is"+words.size());
		return words;
	}


}
