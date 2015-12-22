package edu.asu.passwordvalidator.filter;

public class FilterManager {
	
	


	public FilterChain filterChain;
	
	public FilterManager(Target target)
	{
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}
	
	public void setPasswordFilters(Filter filter)
	{
		filterChain.addPasswordFilter(filter);
	}
	
	
	public String filterPassword(String  message)
	{
		return filterChain.executeFilters(message);
	}
	
	public String postProcess(String message)
	{
		return filterChain.postProcess(message);
	}






}
