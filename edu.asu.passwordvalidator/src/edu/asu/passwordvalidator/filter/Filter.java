package edu.asu.passwordvalidator.filter;

public interface Filter {
	
	public String doFilter(String password);
	
	public String postProcessing(String message);

}
