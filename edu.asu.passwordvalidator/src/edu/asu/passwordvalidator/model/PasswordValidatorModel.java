package edu.asu.passwordvalidator.model;

public class PasswordValidatorModel {


	public enum PasswordValidatorRule {PROPRIETORY_WORDS, OFFENSIVE_WORDS, SALTING};
	private String password;
	private PasswordValidatorRule firstPasswordFilter;
	private PasswordValidatorRule secondPasswordFilter;
	private PasswordValidatorRule thirdPasswordFilter;


	@Override
	public String toString()
	{
		return "Password Validator [ password="+password+", "
				+ "PasswordValidatorRuleType="+firstPasswordFilter+","+
				secondPasswordFilter+","+thirdPasswordFilter+"]";
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the firstPasswordFilter
	 */
	public PasswordValidatorRule getFirstPasswordFilter() {
		return firstPasswordFilter;
	}


	/**
	 * @param firstPasswordFilter the firstPasswordFilter to set
	 */
	public void setFirstPasswordFilter(PasswordValidatorRule firstPasswordFilter) {
		this.firstPasswordFilter = firstPasswordFilter;
	}


	/**
	 * @return the secondPasswordFilter
	 */
	public PasswordValidatorRule getSecondPasswordFilter() {
		return secondPasswordFilter;
	}


	/**
	 * @param secondPasswordFilter the secondPasswordFilter to set
	 */
	public void setSecondPasswordFilter(PasswordValidatorRule secondPasswordFilter) {
		this.secondPasswordFilter = secondPasswordFilter;
	}


	/**
	 * @return the thirsPasswordFilter
	 */
	public PasswordValidatorRule getThirdPasswordFilter() {
		return thirdPasswordFilter;
	}


	/**
	 * @param thirsPasswordFilter the thirsPasswordFilter to set
	 */
	public void setThirdPasswordFilter(PasswordValidatorRule thirdPasswordFilter) {
		this.thirdPasswordFilter = thirdPasswordFilter;
	}




}
