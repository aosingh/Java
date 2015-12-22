package edu.asu.passwordvalidator.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Target {
	
	private boolean isValid;
	private boolean isSalt;

	/**
	 * @return the isSalt
	 */
	public boolean isSalt() {
		return isSalt;
	}

	/**
	 * @param isSalt the isSalt to set
	 */
	public void setSalt(boolean isSalt) {
		this.isSalt = isSalt;
	}

	private static Log logger = LogFactory.getLog(Target.class);
	public void executeRequest(String message)
	{
		if(message.trim().isEmpty())
			this.setValid(false);
		else if(isSalt && message.substring(0, message.lastIndexOf('+')).trim().isEmpty())
			this.setValid(false);
		else
			this.setValid(true);
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
