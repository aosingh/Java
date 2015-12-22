package edu.asu.passwordvalidator.filter;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.asu.passwordvalidator.dao.PasswordFilterDAO;
import edu.asu.passwordvalidator.model.PasswordValidatorConstants.PasswordValidatorRule;

public class SaltPasswordFilter implements Filter {
	
	private static Log logger = LogFactory.getLog(SaltPasswordFilter.class);

	@Override
	public String doFilter(String password) {
		// TODO Auto-generated method stub
		
		String salt = FilterUtility.randomSalt(getListOfSaltWords());
		logger.info("The message after salt is"+password+"+"+salt);
		return password+"+"+salt;
	}

	@Override
	public String postProcessing(String message) {
		// TODO Auto-generated method stub
		logger.info("The message after postProcessing Salt is"+message.substring(0, message.lastIndexOf('+')));
		return message.substring(0, message.lastIndexOf('+'));
		
	}
	
	public List<String> getListOfSaltWords()
	{
		List<String> words = PasswordFilterDAO.getInstance().getListofWords(PasswordValidatorRule.SALTING);
		return words;
	}


}
