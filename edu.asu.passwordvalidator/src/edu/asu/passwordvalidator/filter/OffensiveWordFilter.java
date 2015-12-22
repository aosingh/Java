package edu.asu.passwordvalidator.filter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.asu.passwordvalidator.dao.*;
import edu.asu.passwordvalidator.model.PasswordValidatorConstants.PasswordValidatorRule;

public class OffensiveWordFilter implements Filter{

	private static Log logger = LogFactory.getLog(OffensiveWordFilter.class);
	@Override
	public String doFilter(String password) {
		// TODO Auto-generated method stub

		if(FilterUtility.contain(getListOfOffensiveWords(), password))
		{
			logger.info("The password"+password+"is offensive");
			password = "";
		}
		return password;
	}

	@Override
	public String postProcessing(String message) 
	{
		return message;
	}

	public List<String> getListOfOffensiveWords()
	{
		logger.info("In method getListOfOffensiveWords()");
		List<String> words = PasswordFilterDAO.getInstance().getListofWords(PasswordValidatorRule.OFFENSIVE_WORDS);
		logger.info("The size of offensive words is"+words.size());
		return words;
	}

}
